package com.DuAnTT_LuckyMan.Controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DuAnTT_LuckyMan.entity.CateSmall;
import com.DuAnTT_LuckyMan.entity.Description;
import com.DuAnTT_LuckyMan.entity.Image;
import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.entity.ProductDetail;
import com.DuAnTT_LuckyMan.service.CateSmallService;
import com.DuAnTT_LuckyMan.service.DescriptionService;
import com.DuAnTT_LuckyMan.service.ImageService;
import com.DuAnTT_LuckyMan.service.ProductDetailService;
import com.DuAnTT_LuckyMan.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	CateSmallService catesmalService;
	
	@Autowired
	ProductService productService;

	
	@RequestMapping("/product/list")
	public String list(Model m, @RequestParam("p") Optional<Integer> p, @RequestParam("cid") Optional<String> cid) {
		try {
			if(cid.isPresent()){
				Pageable pa = PageRequest.of(p.orElse(0), 6);
				Page<Product> list = productService.findByCategoryId(cid.get(),pa);
				m.addAttribute("items", list);

				List<CateSmall> list1 = catesmalService.findByCateSmall(cid.get());
				m.addAttribute("catesmall", list1);
				return "layout/product" ;
			}
			else {
				Pageable pa = PageRequest.of(p.orElse(0), 6);
				Page<Product> list = productService.findAvail(pa);
				
				
				int t = list.getTotalPages();
				if (list.getNumber() == t) {
					return "redirect:/product/list?p=0" ;
				}
				
				m.addAttribute("items", list);
			
			}
			Pageable pa = PageRequest.of(p.orElse(0), 10);
			Page<Product> list = productService.findAvail(pa);
		
			int t = list.getTotalPages();
			if (list.getNumber() == t) {
				return "redirect:/product/list?p=0" ;
			}
			
			m.addAttribute("items", list);
			
		} catch (Exception e) {
			return "redirect:/product/list?p=0";
		}
		return "layout/product";

	}
		
	
	@Autowired
	ImageService ImgService;
	
	@Autowired
	DescriptionService DesService;
	
	@Autowired
	ProductDetailService ProDetailService;
	
	

	@RequestMapping("/product/detail/{id}")
	public String detail(Model m, @PathVariable("id") Integer id,@RequestParam("cid") Optional<Integer> cid) {
		
//		if(cid.isPresent()) {
//		    Image image1 = ImgService.findByImagesDetail(cid.get());
//			m.addAttribute("item", image1);
//		}else {
//			Product item = productService.findById(id);
//			m.addAttribute("item", item);
//		}
		
		Product item = productService.findById(id);
		m.addAttribute("item", item);
		List<Description> mota = DesService.findByDescription(id);
		m.addAttribute("des", mota);
		List<Image> image = ImgService.findByImages(id);
		m.addAttribute("images", image);
		List<ProductDetail> detail = ProDetailService.findByProductDetail(id);
		m.addAttribute("detail", detail);
		
		return "layout/productdetail";
	}
	

//	@RequestMapping("/product/detail2/{id}")
//	public String detail2(Model m, @PathVariable("id") Integer id,@RequestParam("cid") Optional<Integer> cid) {
//		
//		if(cid.isPresent()) {
//		    Image image1 = ImgService.findByImagesDetail(cid.get());
//			m.addAttribute("item", image1);
//		}
//	
//		List<Description> mota = DesService.findByDescription(id);
//		m.addAttribute("des", mota);
//		List<Image> image = ImgService.findByImages(id);
//		m.addAttribute("images", image);
//		List<ProductDetail> detail = ProDetailService.findByProductDetail(id);
//		m.addAttribute("detail", detail);
//		
//		return "layout/productdetail2";
//	}
	
	@RequestMapping("/product/catesname/{name}")
	public String detail(Model m, @PathVariable("name") String  name, @RequestParam("cateid") Optional<String> cateid) {
		List<Product>  list = productService.findByNameCate(name,cateid.get());
		m.addAttribute("items", list);
		return "layout/list2";
		
	}
	
//	@RequestMapping("/sale")
//	public String list1(Model m, @RequestParam("p") Optional<Integer> p) {
//		try {
//			Pageable pa = PageRequest.of(p.orElse(0), 6);
//			Page<Product> list = productService.findStatus(pa);
//			int a = list.getTotalPages();
//			if (list.getNumber() == a) {
//				System.err.println("Bạn đang ở cuối danh sách");
//				return "redirect:/product/list?p=0";
//			}
//			m.addAttribute("abc", list);
//		} catch (Exception e) {
//			System.err.println("Bạn đang ở đầu danh sách");
//			return "/product/list";
//		}
//		return "/layout/sale";
//	}
	
	@RequestMapping("/product/list1")
	public String list(Model m,@RequestParam("name") String tensp, @RequestParam("p") Optional<Integer> p ) {
		
		if(tensp !=null) {
		Pageable pa = PageRequest.of(p.orElse(0), 6);
		Page<Product> list = productService.findAllByName("%"+tensp+"%",pa);
		if(list!=null){
			m.addAttribute("items", list);
			m.addAttribute("loiD", "Không tìm thấy sản phẩm phù hợp");
		}else {
			m.addAttribute("loiD", "Không tìm thấy sản phẩm phù hợp");
			m.addAttribute("items", list);
		}
		}
		return "layout/product";
	}

}
