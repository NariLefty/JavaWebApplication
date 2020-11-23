package freeasg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmCancel
 */
@WebServlet("/freeasg/ConfirmCancel")
public class ConfirmCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmCancel() {
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
        PreparedStatement ps = null;

		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>ConfirmCancel</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>予約取消確認</h3>");

			HttpSession session = request.getSession(false);

			if(session != null) {
				session.invalidate();
			}

			session = request.getSession(true);

			try {
				String number = request.getParameter("number");
				int number2 = Integer.parseInt(number);
				CancelingCusInfo cci = new CancelingCusInfo(number2);
				session.setAttribute("cci",cci);

				String sql2 = "select * from FREEASIGNMENT where number = ?";

				String driverUrl = "jdbc:derby:C:\\JavaDB\\freeasgdb;create=false";

				con = DriverManager.getConnection(driverUrl, "db", "db");

				ps = con.prepareStatement(sql2);

				ps.setInt(1,number2);

				ResultSet rs2 = ps.executeQuery();

				out.println("以下の情報を予約取消しますか?");
				out.println("<table border=\"1\">");
				out.println("<tr><td>番号</td><td>名前</td><td>人数</td><td>座席</td><td>予約時刻</td></tr>");
				while(rs2.next()) {
					out.println("<tr><td>" + rs2.getInt("number") + "</td>");
					out.println("<td>" + rs2.getString("name") + "</td>");
					out.println("<td>"+ rs2.getInt("cus_count")+ "</td>");
					out.println("<td>" + rs2.getString("seat") + "</td>");
					out.println("<td>" + rs2.getString("cus_time") + "</td></tr>");
				}
				out.println("</table>");

				out.println("<p><a href=\"CancelingIsDone\">予約取消確定</a></p>");
				out.println("<p><a href=\"Admin\">戻る</a></p>");

				stmt = con.createStatement();

				String sql = "select * from FREEASIGNMENT order by number";
				ResultSet rs = stmt.executeQuery(sql);

				out.println("<table border=\"1\">");
				out.println("<tr><td>番号</td><td>名前</td><td>人数</td><td>座席</td><td>予約時刻</td></tr>");
				while(rs.next()) {
					out.println("<tr><td>" + rs.getInt("number") + "</td>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("<td>"+ rs.getInt("cus_count")+ "</td>");
					out.println("<td>" + rs.getString("seat") + "</td>");
					out.println("<td>" + rs.getString("cus_time") + "</td></tr>");
				}
				out.println("</table>");
			} catch (Exception e) {
				out.println("入力されたデータに誤りがありました");
				out.println("<p><a href=\"Admin\">戻る</a></p>");
			}

			out.println("</body>");
			out.println("</html>");

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
