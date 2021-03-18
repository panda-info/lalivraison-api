package com.lalivraison.api.com.lalivraison.api.controllers;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import com.lalivraison.api.models.Category;
import com.lalivraison.api.models.Description;
import com.lalivraison.api.models.District;
import com.lalivraison.api.models.Location;
import com.lalivraison.api.models.Restaurant;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomePageController {

  private List<Location> locations = asList(
      new Location("1", "Casablanca", asList(
          new District("1", "Maarif"),
          new District("2", "Beauséjour"),
          new District("3", "Ferme Bretonne"),
          new District("4", "Hay tissir"),
          new District("5", "Zone CFC"),
          new District("6", "Riviera"),
          new District("7", "CIL- longchamp-Quartier El Hana"),
          new District("8", "Oasis"),
          new District("9", "Route el jadida - les facultés")
      )),
      new Location("2", "Rabat", asList(
          new District("11", "Agdal haut"),
          new District("12", "Al sabah"),
          new District("13", "Alfath"),
          new District("14", "Amal 2"),
          new District("15", "Amal 3"),
          new District("16", "Amal 6"),
          new District("17", "Ambassadeurs"),
          new District("18", "Ancienne Medina"),
          new District("19", "Aviation")
      )),
      new Location("3", "Marrakech", asList(
          new District("31", "Azzouzia"),
          new District("32", "Palmeraie village 2/ SoGen"),
          new District("33", "Amerchich"),
          new District("34", "Assada"),
          new District("35", "Al Massar"),
          new District("36", "Jardins de la Palmeraie"),
          new District("37", "Sidi Ghanem Zone Industrielle"),
          new District("38", "Al Izdihar"),
          new District("39", "Assif")
      )),
      new Location("4", "Fès", asList(
          new District("41", "Bouramana"),
          new District("42", "Fès bali")
      ))
  );

  @GetMapping("swiper-image")
  public List<String> getSwiperImages() throws IOException {
    try (Stream<Path> paths = Files.walk(Paths.get("src", "main", "resources", "images", "swipper"))) {
      return paths.filter(Files::isRegularFile)
          .map(path -> {
            try {
              byte[] bytes = FileUtils.readFileToByteArray(path.toFile());
              return Base64.getEncoder().encodeToString(bytes);
            } catch (IOException e) {
              e.printStackTrace();
              return e.getMessage();
            }
          })
          .collect(toList());
    }
  }

  @GetMapping("categories")
  public List<Category> getCategories() throws IOException {
    try (Stream<Path> paths = Files.walk(Paths.get("src", "main", "resources", "images",
        "categories"))) {
      ListIterator<String> namesIterator = asList("Tout", "Plats", "Asiatique", "Pizza", "Pâtes", "Salades", "Brunch", "Américain",
              "Thaïe", "Burger", "Boissons").listIterator();

      return paths.filter(Files::isRegularFile)
          .map(path -> {
            try {
              byte[] bytes = FileUtils.readFileToByteArray(path.toFile());
              return new Category(String.valueOf(namesIterator.nextIndex()), namesIterator.next(),
                  Base64.getEncoder().encodeToString(bytes));
            } catch (IOException e) {
              return null;
            }
          })
          .collect(toList());
    }
  }

  @GetMapping("cities")
  public List<Location> getLocations() {
    return locations;

  }

  @GetMapping("restaurants")
  public List<Restaurant> getCategories(@RequestParam String category, @RequestParam Integer page,
      @RequestParam Integer pageSize) throws Exception {
    List<Description> names = asList(new Description("nikkei", asList("Asiatique", "Thaïe", "Boissons")),
        new Description("mamounia", asList("Plats", "Salades", "Boissons")),
        new Description("texas", asList("Américain", "Burger", "Boissons")),
        new Description("damascus", asList("Plats", "Salades", "Boissons")),
        new Description("roma", asList("Pizza", "Pâtes", "Boissons")),
        new Description("bangkok", asList("Asiatique", "Thaïe", "Boissons")),
        new Description("venizia", asList("Pizza", "Pâtes", "Brunch", "Boissons")),
        new Description("l'authentique", asList("Salades", "Brunch", "Boissons")),
        new Description("arabica", asList("Boissons")),
        new Description("bali", asList("Boissons")),
        new Description("hawai", asList("Boissons")),
        new Description("healthy", asList("Plats", "Salades", "Boissons")));
    if (!category.equalsIgnoreCase("tout")) {
      names = names.stream()
          .filter(description -> description.getCategories().contains(category))
          .collect(toList());
    }
    ListIterator<Description> namesIterator = names.listIterator();
    return names.stream().map(name -> {
      try {
        return Files.walk(Paths.get("src", "main", "resources", "images",
            "restaurants", "ok")).filter(path -> path.getFileName().toString().contains(name.getName()))
            .map(path -> {
              try {
                byte[] bytes = FileUtils.readFileToByteArray(path.toFile());
                int nextIndex = namesIterator.nextIndex();
                Description next = namesIterator.next();
                return new Restaurant(String.valueOf(nextIndex), next.getName(),
                    Base64.getEncoder().encodeToString(bytes), true, true,
                    locations.get(nextIndex % 4).getName(), next.getCategories());
              } catch (IOException e) {
                return null;
              }
            })
            .findFirst()
            .get();
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    }).collect(toList());
  }
}
