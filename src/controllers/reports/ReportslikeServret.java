package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import utils.DBUtil;
@WebServlet("/reports/like")
public class ReportslikeServret extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	        // TODO Auto-generated method stub
	        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportslikeServret() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
       
        EntityManager em = DBUtil.createEntityManager();
        
        
        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));

        
        
       
        
        
        
        
        
        int count =1;
        
        
       int result =count+ r.getLike_iine();
       r.setLike_iine(result);
        
      
      
        
       
        
        

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        
        request.getSession().setAttribute("flush", "いいねしました。");
        

        response.sendRedirect(request.getContextPath() + "/reports/index");
    

    }
}



    
    
    


    


