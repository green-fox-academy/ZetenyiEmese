import java.util.ArrayList;

public class Blog {
    private ArrayList<BlogPost> blogPosts;

    public Blog() {
        this.blogPosts = new ArrayList<>();
    }

    public void add(BlogPost blogPost){
        blogPosts.add(blogPost);
    }

    public void delete(int index){
        if (index >= 0 && index < blogPosts.size()){
            blogPosts.remove(index);
        }
    }

    public void update(int index, BlogPost anotherBlogPost){
        if (index >= 0 && index < blogPosts.size()){
            blogPosts.set(index, anotherBlogPost);
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogPosts=" + blogPosts +
                '}';
    }
}