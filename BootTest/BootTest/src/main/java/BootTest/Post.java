package BootTest;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <b>Post est la classe representant un article du blog.</b>
 * <p>
 * Un post est caracterise par les informations suivantes:
 * <ul>
 * <li>Un identifiant unique attribue definitivement par mongodb.</li>
 * <li>Un title, suceptible d'etre change.</li>
 * <li>Un auteur, suceptible d'etre change.</li>
 * <li>Un contenu, suceptible d'etre change.</li>
 * <li>Une liste de commentaires, suceptible d'etre change par ajout.</li>
 * <li>Une date de creation, attribuee definitivement a la creation de l'objet.</li>
 * </ul>
 * </p>
 * @author Ludovic Mantovani
 */
@Document
public class Post
{
	 /**
     * L'ID du Post. Cet ID n'est pas modifiable.
     * Il est gere par mongodb.
     * 
     * @see Post#getId()
     */
	@Id
    private String id;
	

    /**
     * Le titre du Post. Ce titre est changeable.
     * 
     * @see Post#getTitle()
     * @see Post#setTitle(String)
     */
	private String title;
	
    /**
     * L'auteur du Post. L'auteur est changeable.
     * 
     * @see Post#getAuthor()
     * @see Post#setAuthor(String)
     */
	private String author;
	
    /**
     * Le contenu du Post. Le contenu est changeable.
     * 
     * @see Post#getContent()
     * @see Post#setContent(String)
     */
	private String content;
	
    /**
     * Les commentaires du Post. Le contenu est changeable par ajout.
     * 
     * @see Post#getComments()
     * @see Post#addComment(String)
     */
	private ArrayList<String> comments = new ArrayList<String>();
	
    /**
     * La date de creation du Post. La date de creation est attribuee definitivement.
     * 
     * @see Post#getCreation()
     */
    private Date creation;
	
	 /**
     * Constructeur par defaut de Post.
     * <p>
     * A la construction d'un objet Post, le titre, l'auteur et le contenu est fixe par defaut.
     * La date de creation est fixee a la date courante.
     * </p>
     * 
     * @see Post#id
     * @see Post#title
     * @see Post#author
     * @see Post#content
     * @see Post#creation
     */
	public Post()
	{
		this("Title","Author","Content");
	}
	
	 /**
     * Constructeur de Post.
     * <p>
     * A la construction d'un objet Post, la date de creation est fixee a la date courante.
     * </p>
     * 
     * @param title
     * 			Le titre du Post.
     * @param author
     * 			L'auteur du Post.
     * @param content
     * 			Le contenue du Post.
     * 
     * @see Post#id
     * @see Post#title
     * @see Post#author
     * @see Post#content
     * @see Post#creation
     */
	public Post(String title, String author, String content)
	{
		this.title = title;
		this.author = author;
		this.content = content;
		this.creation = new Date();
	}
	
	/**
     * Retourne l'ID du post.
     * 
     * @return L'ID du post, genere par mongodb.
     * 
     * @see Post#id
     */
	public String getId() {
		return id;
	}

	/**
     * Retourne le titre du post.
     * 
     * @return Le titre du post.
     * 
     * @see Post#id
     */
	public String getTitle() {
		return title;
	}

	/**
     * Met a jour le titre du post.
     * 
     * @param title
     * 			Le nouveau titre du post.
     * 
     * @see Post#title
     */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
     * Retourne l'auteur du post.
     * 
     * @return L'auteur du post.
     * 
     * @see Post#author
     */
	public String getAuthor() {
		return author;
	}

	/**
     * Met a jour l'auteur du post.
     * 
     * @param author
     * 			Le nouveau nom d'auteur du post.
     * 
     * @see Post#author
     */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
     * Retourne le contenu du post.
     * 
     * @return Le contenu du post.
     * 
     * @see Post#content
     */
	public String getContent() {
		return content;
	}

	/**
     * Met a jour le contenu du post.
     * 
     * @param content
     * 			Le nouveau contenu du post.
     * 
     * @see Post#content
     */
	public void setContent(String content) {
		this.content = content;
	}

	/**
     * Retourne les commentaires du post.
     * 
     * @return Les commentaires du post.
     * 
     * @see Post#comments
     */
	public ArrayList<String> getComments() {
		return comments;
	}

	/**
     * Ajoute un commentaire au post.
     * 
     * @param commentaire
     * 			Le nouveau commentaire.
     * 
     * @see Post#comments
     */
	public void addComment(String comment) {
		this.comments.add(comment);
	}
	
	/**
     * Retourne le nombre de commentaires du post.
     * 
     * @return Le nombre de commentaires du post.
     * 
     * @see Post#comments
     */
	public int getCommentsNbr() {
		return comments.size();
	}
	
    /**
     * Retourne la date de creation du post.
     * 
     * @return La date de creation du post.
     * 
     * @see Post#create
     */
    public String getCreation() {
    	Locale locale = Locale.getDefault();
    	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
    	
        return dateFormat.format(creation);
    }

}