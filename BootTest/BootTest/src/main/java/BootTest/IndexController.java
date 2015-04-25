package BootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	@Autowired
	PostRepository postRepo;

	//affiche la page d'accueil et tous les posts présents dans la base de données
	 @RequestMapping("/")
	 public ModelAndView index() {
	        final ModelAndView mav = new ModelAndView( "index" );
	        List <Post> posts = postRepo.getAllPost();
	        mav.addObject("posts", posts);
	        return mav;
		}
	 
	//affiche la page de présentation/contact
		 @RequestMapping("contact")
		 public ModelAndView contact() {
		        final ModelAndView mav = new ModelAndView( "contact" );
		        return mav;
			}
		 
		 
	 //affiche la page post.jsp pour lire un post dans son intégralité
	 @RequestMapping( value = "post/{id}" , method = RequestMethod.GET )
	    public ModelAndView afficherPost( @PathVariable( "id" ) final String id ){
	        final ModelAndView mav = new ModelAndView ("post");

	        Post post=postRepo.getPostById(id);
	        mav.addObject( "post", post );
	        return mav;
	    }
	 
	 //permet de supprimer un post et affiche ensuite la page de l'index avec les posts de la BDD
	 @RequestMapping( value = "delete/{id}" , method = RequestMethod.GET )
	    public ModelAndView supprimerPost( @PathVariable( "id" ) final String id ){
	       	postRepo.deletePostById(id);
	        final ModelAndView mav = new ModelAndView( "redirect:/" );
	        List <Post> posts = postRepo.getAllPost();
	        mav.addObject("posts", posts);
	        return mav;
	    }

	 //permet l'affichage de la vue d'édition d'un post
	 @RequestMapping( value = "edit/{id}" , method = RequestMethod.GET )
	    public String editPost( @PathVariable( "id" ) final String id, Model model){
	       Post post=postRepo.getPostById(id);
	       model.addAttribute( "post", post );
	        return "edit";
	    }
	 
	//permet l'affichage de la vue de creation d'un post
	 @RequestMapping( value = "new" , method = RequestMethod.GET )
	    public String editPost(Model model){
	       Post post= new Post();
	       model.addAttribute( "post", post );
	        return "new";
	    }
	 
	 //permet de valider la création d'un post (bouton Creer dans new.jsp)
	 @RequestMapping( value = "valider" , method = RequestMethod.POST )
		public ModelAndView submitnew(@ModelAttribute("post") Post post) { 
		 postRepo.savePost(post);
		 final ModelAndView mav = new ModelAndView( "redirect:/" );
	        List <Post> posts = postRepo.getAllPost();
	        mav.addObject("posts", posts);
	        return mav;
	     	  		 
	    }
	 
	 //permet de valider l'édition d'un post (bouton Modifier dans edit.jsp)
	 @RequestMapping(value = "/edit/valider", method = RequestMethod.POST) 
		public ModelAndView submitedit(@ModelAttribute("post") Post post) { 
		 postRepo.updatePostById(post.getId(), post.getTitle(), post.getAuthor(), post.getContent());
		 final ModelAndView mav = new ModelAndView( "redirect:/" );
	        List <Post> posts = postRepo.getAllPost();
	        mav.addObject("posts", posts);
	        return mav;
	     	  		 
	  
	  
	  	} 





}
