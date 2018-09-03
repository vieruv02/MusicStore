package com.emusicstore2.controller.admin;

import com.emusicstore2.model.Product;
import com.emusicstore2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vladvieru on 8/22/18.
 */

//ProductController can be accessed only by administrator

@Controller
@RequestMapping("/admin")
public class AdminProduct
{
    private Path path;

    @Autowired
    private ProductService productService;

    //ADD PRODUCT STUFF BEGINS

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value="/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request){
        if(result.hasErrors()){
            return "addProduct";
        }

        productService.addProduct(product);
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+product.getProductId()+".png");

        if(productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    //ADD PRODUCT STUFF ENDS


    //EDIT PRODUCT STUFF BEGINS

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }


    @RequestMapping(value="/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request){
        if(result.hasErrors()){
            return "editProduct";
        }


        MultipartFile productImage = product.getProductImage();
        //Getting root directory location
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+product.getProductId()+".png");

        if(productImage!=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    //EDIT PRODUCT STUFF ENDS



    //DELETE PRODUCT STUFF BEGINS

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
        //Getting root directory location
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//"+id+".png");

        //if the file is there then we delete it
        if(Files.exists(path)){
            try {
                Files.delete(path);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }

    //DELETE PRODUCT STUFF ENDS
}