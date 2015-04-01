package BootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@Autowired
	PoneyRepo poneyRepo;
	
	//page d'accueil
	
//	@ResponseBody
//	String home() {
//		return displayer.getInfo();
//	}
	
	
	 @RequestMapping("/")
	 public ModelAndView index() {
	        final ModelAndView mav = new ModelAndView( "index" );
	        Poney poney = poneyRepo.OnePoney();
	        mav.addObject("one",poney);
	        return mav;
		}
	
	 @RequestMapping("/poney")
	 public ModelAndView displayPoney() {
	        final ModelAndView mav = new ModelAndView( "poney" );
	        List <Poney> poneys = poneyRepo.allPoneys();
	        mav.addObject("poney", poneys);
	        
	        return mav;
		}
//	//si on souhaite ajouter un référent dans la BDD gigadbdev il suffit d'entrer l'URL http://localhost:8080/referent/ajouter?label=BIERE
//	@RequestMapping("/referent/ajouter")
//	public @ResponseBody ModelAndView creationReferent(@RequestParam("label") String label){
//		Referent referent = new Referent();
//		referent.setLabel(label);
//		referentMapper.ajouterReferent(referent);
//		final ModelAndView mav = new ModelAndView( "referents" );
//		List<Referent> referents = referentMapper.getAllReferents();
//		mav.addObject("referents", referents);
//		
//		return mav;
//	}
//	
//	//aucun ajout, juste la liste des reférents
//	@RequestMapping("/referent")
//	public @ResponseBody ModelAndView afficherReferent(){
//		final ModelAndView mav = new ModelAndView( "referents" );
//		List<Referent> referents = referentMapper.getAllReferents();
//		mav.addObject("referents", referents);
//		
//		return mav;
//	}

}
