package freeasg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/freeasg/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = null;
        Statement stmt = null;

		try {

			String driverUrl = "jdbc:derby:C:\\JavaDB\\freeasgdb;create=false";

			con = DriverManager.getConnection(driverUrl, "db", "db");

			stmt = con.createStatement();

			String sql = "select * from FREEASIGNMENT order by number";
            ResultSet rs = stmt.executeQuery(sql);

            List<CustomerInfo> clist = new ArrayList<>();

            while (rs.next()) {
                CustomerInfo cti = new CustomerInfo();

                cti.setNumber(rs.getInt("number"));
                cti.setName(rs.getString("name"));
                cti.setCusCount(rs.getInt("cus_count"));
                cti.setSeat(rs.getString("seat"));
                cti.setCusTime(rs.getString("cus_time"));

                clist.add(cti);
            }

			request.setAttribute("clist", clist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
            throw new ServletException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
