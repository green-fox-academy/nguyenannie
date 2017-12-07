import java.util.ArrayList;
import java.util.List;

public class Blog {
    List<BlogPost> listOfBlog;

    public Blog() {
        listOfBlog = new ArrayList<>();
    }
    public void addBlog(BlogPost blogPost){
        listOfBlog.add(blogPost);
    }
    public void deleteBlog(int i){
        listOfBlog.remove(i);
    }
    public void updateBlog(int i, BlogPost blogPost) {
        listOfBlog.set(i, blogPost);
    }
}
