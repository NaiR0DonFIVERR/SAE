package ComposantGraphique.Box;

import Constantes.ConstantesMenu;
import javafx.scene.control.*;


public class MenuBarChoixUtilisateur extends MenuBar implements ConstantesMenu {

    MenuBar menuBar;

    public MenuBarChoixUtilisateur(){
        menuBar = new MenuBar();
        Menu menu = new Menu("CHOIX");
        menuBar.getMenus().add(menu);
        for (int i=0; i<CHOIX_MENU.length; i++){
            MenuItem menuItem = new MenuItem(CHOIX_MENU[i]);
            menuItem.setUserData(i);
            menu.getItems().add(menuItem);
        }
    }

    public MenuBar getMenuBar(){
        return menuBar;
    }
}
