package BootTest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("administrateur")
public class IndexController {

	@Autowired
	PostRepository postRepo;

	@Autowired
	UserRepository userRepo;


	// page d'accueil (aucun droit d'admin par defaut donc btn
	// modifier/supprimer non affichées)
	@RequestMapping("/")
	public ModelAndView index(final HttpSession session) {
		final ModelAndView mav = new ModelAndView("index");
		List<Post> posts = postRepo.getAllPost();
		boolean administrateur = false;
		mav.addObject("posts", posts);
		mav.addObject("administrateur", administrateur);
		return mav;
	}

	// affiche l'index en prenant en compte le fait qu'une personne soit
	// connectée et puisse donc gérer le blog
	@RequestMapping("index")
	public ModelAndView retour(final HttpSession session) {
		final ModelAndView mav = new ModelAndView("index");
		List<Post> posts = postRepo.getAllPost();
		mav.addObject("posts", posts);
		mav.addObject("administrateur", session.getAttribute("administrateur"));
		return mav;
	}

	// affiche l'index et renvoie à la methode retour(final HttpSession session)
	// afin d'afficher toutes les info nécessaires
	@RequestMapping(value = { "retour", "post/retour", "edit/retour", "new/retour", "comment/retour"   })
	public ModelAndView retour() {
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}

	// affiche l'index en prenant en compte le fait qu'une personne soit
	// connectée et puisse donc gérer le blog
	@RequestMapping("logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("redirect:/");
		return mv;
	}

	// affiche la page de présentation/contact
	@RequestMapping(value = { "contact", "post/contact", "edit/contact", "new/contact"})
	public ModelAndView contact() {
		final ModelAndView mav = new ModelAndView("contact");
		return mav;
	}

	// affiche la page de login
	@RequestMapping(value = { "login", "post/login", "contact/login"})
	public ModelAndView login() {
		final ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}

	// valide la connexion ou la refuse
	@RequestMapping(value = "connexion", method = RequestMethod.POST)
	public ModelAndView identificationSubmit(@ModelAttribute("user") User user,
			final HttpSession session) {
		User utilisateur = userRepo.getUser(user.getPseudonyme(),
				user.getPassword());
		if (utilisateur != null) {
			session.setAttribute("administrateur", true);
			List<Post> posts = postRepo.getAllPost();
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("administrateur",
					session.getAttribute("administrateur"));
			mv.addObject("posts", posts);
			return mv;
		} else {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		}

	}

	// affiche la page post.jsp pour lire un post dans son intégralité
	@RequestMapping(value = "post/{id}", method = RequestMethod.GET)
	public ModelAndView afficherPost(@PathVariable("id") final String id) {
		final ModelAndView mav = new ModelAndView("post");
		Post post = postRepo.getPostById(id);
		mav.addObject("post", post);
		return mav;
	}

	// permet de supprimer un post et affiche ensuite la page de l'index avec
	// les posts de la BDD
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView supprimerPost(@PathVariable("id") final String id) {
		postRepo.deletePostById(id);
		final ModelAndView mav = new ModelAndView("redirect:/index");
		List<Post> posts = postRepo.getAllPost();
		mav.addObject("posts", posts);
		return mav;
	}

	// permet l'affichage de la vue d'édition d'un post
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") final String id, Model model) {
		Post post = postRepo.getPostById(id);
		model.addAttribute("post", post);
		return "edit";
	}

	// permet l'affichage de la vue de creation d'un post
	@RequestMapping(value = { "new", "post/new", "edit/new", "contact/new"}, method = RequestMethod.GET)
	public String newPost(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "new";
	}

	// permet de valider la création d'un post (bouton Creer dans new.jsp)
	@RequestMapping(value = "valider", method = RequestMethod.POST)
	public ModelAndView submitnew(@ModelAttribute("post") Post post,
			final HttpSession session) {
		postRepo.savePost(post);
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}

	// permet de valider l'édition d'un post (bouton Modifier dans edit.jsp)
	@RequestMapping(value = "/edit/valider/{id}", method = RequestMethod.POST)
	public ModelAndView submitedit(@ModelAttribute("post") Post post, @PathVariable("id") final String id,
			final HttpSession session) {
		postRepo.updatePostById(id, post.getTitle(),
				post.getAuthor(), post.getContent());
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}

	// permet de valider l'ajout d'un commentaire (bouton Ajouter dans post.jsp)
	@RequestMapping(value = "/post/valider_commentaire", method = RequestMethod.POST)
	public ModelAndView submitenewcomment(@ModelAttribute("id") String id,
			@ModelAttribute("comments") String comment,
			final HttpSession session) {
		postRepo.addCommentByPostId(id, comment);
		ModelAndView mv = new ModelAndView("redirect:/post/" + id);
		return mv;
	}

}
