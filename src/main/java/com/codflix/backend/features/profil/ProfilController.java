package com.codflix.backend.features.profil;

import com.codflix.backend.core.Template;
import com.codflix.backend.features.user.AuthController;
import com.codflix.backend.features.user.UserDao;
import com.codflix.backend.models.User;
import com.codflix.backend.utils.URLUtils;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

public class ProfilController {
    private final AuthController authController = new AuthController();
    private final ProfilDao profilDao = new ProfilDao();
    User user;
    private final UserDao userDao = new UserDao();

    public String profil(Request request, Response response) {
        Session session = request.session(true);
        int userId = session.attribute("user_id");


        user = userDao.getUserById(userId);


        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        return Template.render("profil.html", model);
    }

    /***
     * function that gets inputs of the user and verify password and send informations to ProfilDao
     * @param request
     * @param response
     * @return a String to know if things are ok
     */
    public String getChangeProfil(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        if (request.requestMethod().equals("GET")) {
            return Template.render("profil.html", model);
        }
        Map<String, String> query = URLUtils.decodeQuery(request.body());
        String email = query.get("email");
        String password = query.get("password");
        String passwordConfirm = query.get("password_confirm");


        if (authController.hash(passwordConfirm).equals(user.getPassword())) {
            if (!email.isEmpty()){
            profilDao.updateEmail(email,user.getId());

            }
            if (!password.isEmpty()) {
                profilDao.updatePassword(authController.hash(password),user.getId());

            }

        }
        return "Vos informations ont bien été enregistrées";
    }


}






