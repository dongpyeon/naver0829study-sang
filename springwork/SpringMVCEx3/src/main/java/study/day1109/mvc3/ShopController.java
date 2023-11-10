package study.day1109.mvc3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller  // controller만들면 항상 이걸 넣어주어야 한다.
public class ShopController {
	
	@GetMapping("/") //root일때
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/shop/{path}")
	//public String list(@PathVariable("path" String path) : path와 변수명이 같을경우 생략
	//public String list(@PathVariable String path)
	public String list(@PathVariable String path, Model model)
	{	
		System.out.println(path);
		String shopinfo="";
		if(path.equals("list1"))
			shopinfo="원피스 상품 목록";
		else if(path.equals("list2"))
			shopinfo="슈즈 상품 목록";
		else
			shopinfo="악세사리 상품 목록";
		
		//상품 목록 담기
		List<ShopDto> list = new ArrayList<ShopDto>();
		if(path.equals("list1")) {
			list.add(new ShopDto("화이트원피스", "2.jpg", 99000));
			list.add(new ShopDto("스포티원피스", "25.jpg", 45000));
			list.add(new ShopDto("레이스원피스", "28.jpg", 68000));
			list.add(new ShopDto("청원피스", "2.jpg", 23000));
		}else if(path.equals("list2")) {
			list.add(new ShopDto("샤넬슈즈", "12.jpg", 150000));
			list.add(new ShopDto("구찌슈즈", "14.jpg", 980000));
			list.add(new ShopDto("플렛슈즈", "15.jpg", 33000));
		}else {
			list.add(new ShopDto("리본핀", "19.jpg", 11000));
			list.add(new ShopDto("머리띠", "30.jpg", 23000));
			list.add(new ShopDto("진주반지", "21.jpg", 55000));
			list.add(new ShopDto("머리끈", "26.jpg", 9000));
		}
		
		model.addAttribute("list",list);
		model.addAttribute("count",list.size());
		model.addAttribute("shopinfo", shopinfo);
		return "list1";
	}
	
	//내가 한것
	/* @GetMapping("/food/morning/brunch")
	public String brunch(Model model)
	{
		String foodinfo="메뉴들";
		String message="오늘의 브런치 메뉴들";
		List<String> list2 = new Vector<String>();
			list2.add("K-034.png");
			list2.add("K-035.png");
			list2.add("K-036.png");
		
		
		//List<ShopDto> list = new ArrayList<ShopDto>();

		model.addAttribute("foodinfo",foodinfo);
		model.addAttribute("message",message);
		model.addAttribute("list2", list2);
		return "list2";	
	}
	
	@GetMapping("/food/photo/detail")
	public String list3(Model model)
	{
		String foodinfo="메뉴들";
		List<FoodDto> list = new ArrayList<FoodDto>();
			list.add(new FoodDto("김봉남","10.jpg","강남"));
			list.add(new FoodDto("조주봉","12.jpg","서면"));
			list.add(new FoodDto("황의조","6.jpg","대구"));
		
		model.addAttribute("foodinfo",foodinfo);
		model.addAttribute("list",list);
		return "list3";	
	} */
	
	@GetMapping("/food/morning/brunch")
	public String brunch(Model model)
	{
		model.addAttribute("message", "오늘의 브런치 메뉴들");
		model.addAttribute("today", new Date());
		
		List<String> list = new ArrayList<String>();
		list.add("K-034.png");
		list.add("K-035.png");
		list.add("K-036.png");
		
		model.addAttribute("list", list);
		
		return "list2";
	}
	
	@GetMapping("/food/photo/detail")
	public ModelAndView detail()
	{
		ModelAndView mview = new ModelAndView();
		
		List<String> list = new ArrayList<String>();
		list.add("10.jpg");
		list.add("12.jpg");
		list.add("6.jpg");
		mview.addObject("food", list);
		mview.addObject("name", "조주봉");
		mview.addObject("addr", "서울시 남딘시 낌선현");
		
		mview.setViewName("list3");
		
		return mview;
	}
	
}
