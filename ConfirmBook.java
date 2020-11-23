package freeasg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmBook
 */
@WebServlet("/freeasg/ConfirmBook")
public class ConfirmBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>ConfirmBook</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>予約確認</h3>");


			HttpSession session = request.getSession(false);

			if(session != null) {
				session.invalidate();
			}

			session = request.getSession(true);

			String name = request.getParameter("name");
			String cusCount = request.getParameter("cusCount");
			String smooking = request.getParameter("radio1");


			try {
				int cusCount2 = Integer.parseInt(cusCount);
				BookkingCusInfo bci = new BookkingCusInfo(name,cusCount2,smooking);
				session.setAttribute("bci", bci);
				out.println("以下の情報で予約しますか?");
				out.println("<table>");
				out.println("<tr><td>名前：</td><td>"+ name +"</td></tr>");
				out.println("<tr><td>人数：</td><td>"+ cusCount +"人"+ "</td></tr>");
				out.println("<tr><td>座席；</td><td>" + smooking + "</td></tr>");
				out.println("</table>");

				out.println("<p><a href=\"BookkingIsDone\">予約確定</a></p>");
				out.println("<p><a href=\"Customer\">戻る</a></p>");
			} catch (Exception e) {
				out.println("入力されたデータに誤りがありました");
				out.println("<p><a href=\"Customer\">戻る</a></p>");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
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
