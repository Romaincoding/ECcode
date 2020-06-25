package com.codflix.backend.features.stream;

import com.codflix.backend.core.Template;
import com.codflix.backend.features.history.HistoryDao;
import com.codflix.backend.features.media.MediaDao;
import com.codflix.backend.features.user.UserDao;
import com.codflix.backend.models.Media;
import com.codflix.backend.models.User;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamController {
    UserDao userDao = new UserDao();
    HistoryDao historyDao = new HistoryDao();
    MediaDao mediaDao = new MediaDao();
    User user;


    public String stream(Request request, Response response) {
        List<Media> medias;


        Session session = request.session(true);
        int userId = session.attribute("user_id");
        User user = userDao.getUserById(userId);
         medias = mediaDao.getAllMedias();
        Map<String, Object> model = new HashMap<>();
        model.put("medias", medias);
        model.put("user", user);

        return Template.render("stream.html", model);
    }
}


