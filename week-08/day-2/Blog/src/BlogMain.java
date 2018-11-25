public class BlogMain {
    public static void main(String[] args) {
        Blog blog = new Blog();

        blog.add(new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04"));
        blog.add(new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10"));
        blog.add(new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28"));

        System.out.println(blog);

        blog.delete(2); // removes the item at index=2
        System.out.println(blog);

        blog.delete(5); // nothing happens because index=5 doesn't exist
        System.out.println(blog);

        // updates the item at index=0 with the new blogpost
        blog.update(0, new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28"));
        System.out.println(blog);

        // nothing happens because index=3 doesn't exist
        blog.update(3, new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28"));
        System.out.println(blog);
    }
}