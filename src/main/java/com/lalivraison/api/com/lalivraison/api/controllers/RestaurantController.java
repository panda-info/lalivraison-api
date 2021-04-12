package com.lalivraison.api.com.lalivraison.api.controllers;

import static java.util.Arrays.asList;

import com.lalivraison.api.models.restaurant.Category;
import com.lalivraison.api.models.restaurant.Item;
import com.lalivraison.api.models.restaurant.RestaurantDetails;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  public static String imageToBase64(String image) throws IOException {
    try (Stream<Path> paths = Files.walk(Paths.get("src", "main", "resources", "images", "restaurant"))) {
      return paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().contains(image))
          .map(path -> {
            try {
              byte[] bytes = FileUtils.readFileToByteArray(path.toFile());
              return Base64.getEncoder().encodeToString(bytes);
            } catch (IOException e) {
              e.printStackTrace();
              return e.getMessage();
            }
          })
          .findFirst()
          .get();
    }
  }

  @GetMapping("/restaurant")
  RestaurantDetails getRestaurantDetails(@RequestParam String restaurantId,
      @RequestParam(required = false) String districtId) throws IOException {
    return new RestaurantDetails("1", imageToBase64("image.jpg"), imageToBase64("sub.jpg"), "NIKKEI.MA",
        "Cuisine Nippone", 140, 20, "05 22 99 48 77",
        "11", "23", "NIKKEI met un point d\\'honneur à développer une "
        + "large gamme de sushis, de plateaux...", asList(
        new Category("1", "Entrées",
            asList(
                new Item("1", imageToBase64("p1.png"), "SALADE DE CHOUX",
                    25, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI.MA"),
                new Item("2", imageToBase64("p2.png"), "WAKAME SAUMON",
                    60, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI.MA"),
                new Item("3", imageToBase64("p3.png"), "GAMBAS TEMPURA",
                    65, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI.MA")
//                new Item("4", "../../../assets/images/p3.png", "GAMBAS TEMPURA",
//                    65, "Chou et carotte émincé vinaigrette au soja.", "NIKKEI.MA")

        )),
        new Category("2", "Tartare", asList(
            new Item("5", imageToBase64("SALMON-AVOCADO-TARTARE.png"), "SALMON AVOCADO TARTARE",
                55, "Saumon, avocat, sésame, boulette de riz vinaigré, sauce Nikkei servie"
                + " à part", "NIKKEI.MA"),
            new Item("6", imageToBase64("TUNA-SALMON-TARTARE-(NEW).jpg"), "TUNA SALMON TARTARE (NEW)",
                65, "Poisson blanc, mangue, avocat, menthe ciselée, boulette de riz vinaigré,"
                + " sauce Ponzu servie à part", "NIKKEI.MA")
        )),
//        new Category("3", "Tartare", asList(
//            new Item("7", imageToBase64("SALMON-AVOCADO-TARTARE.png"), "SALMON AVOCADO TARTARE",
//                55, "Saumon, avocat, sésame, boulette de riz vinaigré, sauce Nikkei servie"
//                + " à part", "NIKKEI.MA"),
//            new Item("8", imageToBase64("CRABE-TARTARE.png"), "CRABE TARTARE",
//                59, "Tartare de crabe, avocat, masago, boulette de riz vinaigré, Mayo épicé", "NIKKEI.MA")
//        )),
        new Category("3", "Tiradito", asList(
            new Item("9", imageToBase64("SALMON-TIRADITO.png"), "SALMON TIRADITO",
                55, "7P. Saumon, oignon, ciboulette, coriandre, sauce nikkei", "NIKKEI.MA"),
            new Item("10", imageToBase64("MAHI-MAHI-TIRADITO.png"), "MAHI MAHI TIRADITO",
                55, "7P. Poisson blanc, menthe, graines de sésame, sauce Ponzu", "NIKKEI.MA")
        )),
        new Category("3", "Tataki", asList(
            new Item("11", imageToBase64("SALMON-TATAKI.png"), "SALMON TATAKI",
                50, "5P. Saumon mi-cuit, sésame, sauce NIKKEI", "NIKKEI.MA"),
            new Item("12", imageToBase64("TUNA-TATAKI.png"), "TUNA TATAKI",
                50, "5P. Thon mi-cuit, sésame, sauce PONZU", "NIKKEI.MA")
        )),
        new Category("4", "Chirashi", asList(
            new Item("13", imageToBase64("SALMON-CHIRACHI.png"), "SALMON CHIRACHI",
                55, "Sashimi saumon, riz vinaigré , sésame, soja sauce", "NIKKEI.MA"),
            new Item("14", imageToBase64("SALMON-AVOCADO-CHIRACHI.png"), "SALMON AVOCADO CHIRACHI",
                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA"),
            new Item("15", imageToBase64("TUNA-SALMON-CHIRASHI.jpg"), "TUNA SALMON CHIRASHI",
                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA")
//            new Item("13", imageToBase64("SALMON-CHIRACHI.png"), "SALMON CHIRACHI",
//                55, "Sashimi saumon, riz vinaigré , sésame, soja sauce", "NIKKEI.MA"),
//            new Item("14", imageToBase64("SALMON-AVOCADO-CHIRACHI.png"), "SALMON AVOCADO CHIRACHI",
//                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA"),
//            new Item("15", imageToBase64("TUNA-SALMON-CHIRASHI.jpg"), "TUNA SALMON CHIRASHI",
//                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA"),
//            new Item("13", imageToBase64("SALMON-CHIRACHI.png"), "SALMON CHIRACHI",
//                55, "Sashimi saumon, riz vinaigré , sésame, soja sauce", "NIKKEI.MA"),
//            new Item("14", imageToBase64("SALMON-AVOCADO-CHIRACHI.png"), "SALMON AVOCADO CHIRACHI",
//                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA"),
//            new Item("15", imageToBase64("TUNA-SALMON-CHIRASHI.jpg"), "TUNA SALMON CHIRASHI",
//                60, "Sashimi saumon, avocat, riz vinaigré, sésame, soja sauce", "NIKKEI.MA")
        )),
        new Category("5", "Yakitori", asList(
            new Item("16", imageToBase64("CHICKEN-BALLS.png"), "CHICKEN BALL\'S",
                39, "Boulette de poulet, sauce teriyaki", "NIKKEI.MA"),
            new Item("17", imageToBase64("CHICKEN-YAKI-(NEW).png"), "CHICKEN YAKI (NEW)",
                39, "Boulette de poulet, sauce teriyaki", "NIKKEI.MA"),
            new Item("18", imageToBase64("BEEF-CHEESE.png"), "BEEF CHEESE",
                45, "Bœuf fromage, sauce teriyaki", "NIKKEI.MA")
        ))
    ));
  }
}
