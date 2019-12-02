package cn.jxufe.controller;

import cn.jxufe.result.CodeMsg;
import cn.jxufe.result.Result;
import cn.jxufe.service.RpcService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class DemoController {

		@Reference(url = "dubbo://127.0.0.1:20880",version = "2.0")
		private RpcService rpcService;

	 	@RequestMapping("/")
	    @ResponseBody
	    String home() {
			return rpcService.returnValue();
	    }
	 	//1.rest api json输出 2.页面
	 	@RequestMapping("/hello")
	    @ResponseBody
	    public Result<String> hello() {
	 		return Result.success("hello,imooc");
	       // return new Result(0, "success", "hello,imooc");
	    }
	 	
	 	@RequestMapping("/helloError")
	    @ResponseBody
	    public Result<String> helloError() {
	 		return Result.error(CodeMsg.SERVER_ERROR);
	 		//return new Result(500102, "XXX");
	    }
	 	
	 	@RequestMapping("/thymeleaf")
	    public String  thymeleaf(Model model) {
	 		model.addAttribute("name", "Joshua");
	 		return "hello";
	    }
	 	
}
