package study.day1108;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myshop.data.MyShopDto;


@WebServlet("/cjhome/myshop/list")
public class MyShopServletList extends HttpServlet {
	
	List<MyShopDto> list = new Vector<MyShopDto>();
	
	public MyShopServletList() {
		list.add(new MyShopDto(100, "자켓", "32.jpg", 34000, "pink"));
		list.add(new MyShopDto(100, "머리띠", "30.jpg", 19000, "orange"));
		list.add(new MyShopDto(100, "단화", "14.jpg", 56000, "green"));
		list.add(new MyShopDto(100, "원피스", "25.jpg", 27000, "magenta"));
		list.add(new MyShopDto(100, "머리끈", "26.jpg", 11000, "yellow"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("total", list.size());
		request.setAttribute("list", list);
		request.setAttribute("today", new Date());
		
		//포워드
		RequestDispatcher rd = request.getRequestDispatcher("../../day1108/myshoplist.jsp"); //현재 mapping주소 기준으로 /ServletProject/cjhome/myshop/list 여기서 2번 올라와서 day의/myshoplist.jsp로 가는것이다.
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
