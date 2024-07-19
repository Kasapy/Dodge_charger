import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        int i = 0;
        List<Posts> posts = new ArrayList<>();
        Posts anticopied = new Posts();

        while (i <= 0) {
            Thread.sleep(3000);
            // Fetch the main page
            Document doc = Jsoup.connect("https://cars.av.by/filter?sort=4").get();

            Element postTitleElement = doc.getElementsByClass("listing-item__link").first();

            String detailsLink = null;
            if (postTitleElement != null) {
                detailsLink = "https://cars.av.by" + postTitleElement.attr("href");
            }
            Posts post = new Posts();
            post.setDetailLink(detailsLink);

            if (detailsLink != null) {
                // Fetch the post details page
                Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                post.setPlacement(postDetailsDoc.getElementsByClass("card__location").first().text());
                post.setPrice(postDetailsDoc.getElementsByClass("card__price-secondary").first().text());
            }

            if (posts.size() == 0) {
                posts.add(post);
            } else if (!post.equals(posts.get(posts.size() - 1))) {
                posts.add(post);
            } else {
                continue;
            }

            System.out.println(posts.get(posts.size() - 1));
        }
    }
}