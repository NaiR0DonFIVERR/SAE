package ComposantGraphique.Box;

import Constantes.ConstantesMenu;
import javafx.scene.control.*;
import vue.VBoxRoot;


public class MenuBarChoixUtilisateur extends MenuBar implements ConstantesMenu {

    MenuBar menuBar;

    public MenuBarChoixUtilisateur(){
        menuBar = new MenuBar();
        Menu menu = new Menu("CHOIX");
        menuBar.getMenus().add(menu);
        for (int i=0; i<CHOIX_MENU.length; i++){
            MenuItem menuItem = new MenuItem(CHOIX_MENU[i]);
            menuItem.setUserData(i);
            menuItem.setOnAction(VBoxRoot.getControler());
            menu.getItems().add(menuItem);
        }
        menuBar.setId("menuBar");
    }

    public MenuBar getMenuBar(){
        return menuBar;
    }
}
