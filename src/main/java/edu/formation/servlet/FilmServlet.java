package edu.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.formation.dao.FilmDao;
import edu.formation.dao.FilmDaoSql;
import edu.formation.model.Film;

/**
 * Servlet implementation class FilmServlet
 */
@WebServlet(urlPatterns = { "/film" })
public class FilmServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // l'URL contient-elle le param�tre id ?
        if (request.getParameter("id") != null)
        {
            try
            {
                // je r�cup�re sa valeur
                int id = Integer.parseInt(request.getParameter("id"));
                // je r�cup�re le film avec cet id
                FilmDao filmDao = new FilmDaoSql();
                Film film = filmDao.findById(id);
                if (film != null)
                {
                    // je passe le film � la requ�te
                    request.setAttribute("film", film);
                }
                else
                {
                    String erreur = "Aucun film avec cet id";
                    request.setAttribute("error", erreur);
                }
            }
            catch (NumberFormatException e)
            {
                String erreur = "L'identifiant doit �tre un entier";
                request.setAttribute("error", erreur);
            }

            // je transmets la requ�te � la jsp
            request.getRequestDispatcher("/film.jsp").forward(request, response);

        }
        // la requ�te ne contient pas le param�tre 'id'
        else
        {
            // je vais chercher tous les films
            FilmDao filmDao = new FilmDaoSql();
            List<Film> films = filmDao.findAll();
            // injection dans la requ�te
            request.setAttribute("films", films);
            // transfert
            request.getRequestDispatcher("films.jsp").forward(request, response);

        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }

}
