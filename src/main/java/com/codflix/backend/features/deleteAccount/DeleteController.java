package com.codflix.backend.features.deleteAccount;

import com.codflix.backend.core.Template;
import com.codflix.backend.features.profil.ProfilDao;
import com.codflix.backend.features.user.AuthController;
import com.codflix.backend.features.user.UserDao;
import com.codflix.backend.models.User;
import com.codflix.backend.utils.URLUtils;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

public class DeleteController {
    private final AuthController authController = new AuthController();
    private final ProfilDao profilDao = new ProfilDao();
    User user;
    private final UserDao userDao = new UserDao();
    private final DeleteDao deleteDao = new DeleteDao();

    public String delete(Request request, Response response) {
        Session session = request.session(true);
        int userId = session.attribute("user_id");


        user = userDao.getUserById(userId);

        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        return Template.render("delete_account_confirm.html", model);
    }


    /***
     * function that verify password and send informations to DeleteDao to delete an account in the database
     * @param request
     * @param response
     * @return
     */
    public String deleteAccount(Request request, Response response) {
        Map<String, String> query = URLUtils.decodeQuery(request.body());
        String password = query.get("password");
        if (authController.hash(password).equals(user.getPassword())) {

            deleteDao.deleteAccount(user.getId());


            return "Votre compte a bien été supprimé!";
        }
        return "Oups désolé il y a eu un problème!";
    }

}
