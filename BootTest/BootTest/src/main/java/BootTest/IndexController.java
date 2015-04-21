package BootTest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@Autowired
	PostRepository postRepo;

	 @RequestMapping("/")
	 public ModelAndView index() {
	        final ModelAndView mav = new ModelAndView( "index" );
	        List <Post> posts = postRepo.getAllPost();
	        mav.addObject("posts", posts);
	        return mav;
		}
	 
	 
	 @RequestMapping( value = "post/{id}" , method = RequestMethod.GET )
	    public ModelAndView afficherPost( @PathVariable( "id" ) final String id ){
	        final ModelAndView mav = new ModelAndView ("post");

	        Post post=postRepo.getPostById(id);
	        mav.addObject( "post", post );
	        return mav;
	    }



}
