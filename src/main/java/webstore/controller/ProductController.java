package webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webstore.service.ProductService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("market")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params")
                                      Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:/products";
    }

    @RequestMapping("/products/{category}/{params}")
    public String filterProducts(@PathVariable("category") String productCategory,
                                 @MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
                                 @RequestParam("brand") String productBrand,
                                 Model model) {
        model.addAttribute("products", productService.getProductsByManyParams(productCategory,
                filterParams, productBrand));
        return "products";
    }
}
