//        LocalDateTime d1 = LocalDateTime.parse("2018-06-13T13:05:44");
//        LocalDateTime d2 = LocalDateTime.parse("2018-07-28T23:14:19");
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        //LocalDateTime post1 = fmt.format("13/06/2018 13:05:44");
//        List<Post> posts = new ArrayList<>();
//        Post post1 = new Post(d1, "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
//        Post post2 = new Post(d2, "Good night guys", "See you tomorrow", 5);
//        posts.add(post1);
//        posts.add(post2);
//
//        for (int i=1; i<= 2; i++) {
//            posts.addAll(posts);
//        }
//        System.out.println(posts);
package org.example.application;
import org.example.entitites.Comment;
import org.example.entitites.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Program2 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome!");
        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);
        p1.addComment(c1);
        p1.addComment(c2);

        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you");
        Post p2 = new Post(
                sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5);
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);






    }
}
