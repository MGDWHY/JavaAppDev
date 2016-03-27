package popupcontroltest;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PopupControlTest extends Application
{
   private static Stage LOGIN_DIALOG;
   private static int dx = 1;
   private static int dy = 1;

   public static void main(String[] args)
   {
      Application.launch(args);
   }

   private static Stage createLoginDialog(Stage parent, boolean modal)
   {
      if (LOGIN_DIALOG != null)
      {
         LOGIN_DIALOG.close();
      }
      return new MyDialog(parent, modal, "Welcome to JavaFX!");
   }

   @Override
   public void start(final Stage primaryStage)
   {
      primaryStage.setTitle("Popup Dialog");
      Group root = new Group();
      Scene scene = new Scene(root, 433, 312, Color.WHITE);

      MenuBar menuBar = new MenuBar();
      menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

      Menu menu = new Menu("Home");

      // Добавим элемент меню Change Password
      MenuItem newItem = new MenuItem("Change Password", null);
      newItem.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            if (LOGIN_DIALOG == null)
            {
               LOGIN_DIALOG = createLoginDialog(primaryStage, true);
            }
            LOGIN_DIALOG.sizeToScene();
            LOGIN_DIALOG.show();
         }
      });

      menu.getItems().add(newItem);

      // Добавим сепаратор
      menu.getItems().add(new SeparatorMenuItem());

      // Добавим радио-кнопку меню для изменения модальности окна
      ToggleGroup modalGroup = new ToggleGroup();
      RadioMenuItem nonModalItem = RadioMenuItemBuilder.create().toggleGroup(modalGroup).text("Non Modal").
        selected(true).build();
      nonModalItem.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            LOGIN_DIALOG = createLoginDialog(primaryStage, false);
         }
      });

      menu.getItems().add(nonModalItem);

      // Добавим выбор модальности
      RadioMenuItem modalItem = RadioMenuItemBuilder.create().toggleGroup(modalGroup).text("Modal").selected(
        true).build();
      modalItem.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            LOGIN_DIALOG = createLoginDialog(primaryStage, true);
         }
      });
      menu.getItems().add(modalItem);

      // add separator
      menu.getItems().add(new SeparatorMenuItem());

      // add exit
      MenuItem exitItem = new MenuItem("Exit", null);
      exitItem.setMnemonicParsing(true);
      exitItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
      exitItem.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            Platform.exit();
         }
      });
      menu.getItems().add(exitItem);

      // Добавим меню
      menuBar.getMenus().add(menu);

      // Добавим меню-бар
      root.getChildren().add(menuBar);

      primaryStage.setScene(scene);
      primaryStage.show();

      addBouncyBall(scene);
   }

   private void addBouncyBall(final Scene scene)
   {

      final Circle ball = new Circle(100, 100, 20);
      RadialGradient gradient1 = new RadialGradient(0,
                                                    .1,
                                                    100,
                                                    100,
                                                    20,
                                                    false,
                                                    CycleMethod.NO_CYCLE,
                                                    new Stop(0, Color.RED),
                                                    new Stop(1, Color.BLACK));

      ball.setFill(gradient1);

      final Group root = (Group) scene.getRoot();
      root.getChildren().add(ball);

      Timeline tl = new Timeline();
      tl.setCycleCount(Animation.INDEFINITE);
      KeyFrame moveBall = new KeyFrame(Duration.seconds(.0200),
                                       new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {

            double xMin = ball.getBoundsInParent().getMinX();
            double yMin = ball.getBoundsInParent().getMinY();
            double xMax = ball.getBoundsInParent().getMaxX();
            double yMax = ball.getBoundsInParent().getMaxY();

            // Collision - boundaries
            if (xMin < 0 || xMax > scene.getWidth())
            {
               dx *= -1;
            }
            if (yMin < 0 || yMax > scene.getHeight())
            {
               dy *= -1;
            }

            ball.setTranslateX(ball.getTranslateX() + dx);
            ball.setTranslateY(ball.getTranslateY() + dy);

         }
      });

      tl.getKeyFrames().add(moveBall);
      tl.play();
   }
}

class MyDialog extends Stage
{
   MyDialog(Stage owner, boolean modality, String title)
   {
      super();
      initOwner(owner);
      Modality m = modality ? Modality.APPLICATION_MODAL : Modality.NONE;
      initModality(m);
      setOpacity(.90);
      setTitle(title);
      Group root = new Group();
      Scene scene = new Scene(root, 250, 150, Color.WHITE);
      setScene(scene);

      GridPane gridpane = new GridPane();
      gridpane.setPadding(new Insets(5));
      gridpane.setHgap(5);
      gridpane.setVgap(5);

      Label mainLabel = new Label("Enter User Name & Password");
      gridpane.add(mainLabel, 1, 0, 2, 1);

      Label userNameLbl = new Label("User Name: ");
      gridpane.add(userNameLbl, 0, 1);

      Label passwordLbl = new Label("Password: ");
      gridpane.add(passwordLbl, 0, 2);

      // Пользователь
      final TextField userNameFld = new TextField("Admin");
      gridpane.add(userNameFld, 1, 1);

      // Пароль
      final PasswordField passwordFld = new PasswordField();
      passwordFld.setText("drowssap");
      gridpane.add(passwordFld, 1, 2);


      Button login = new Button("Change");
      login.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle(ActionEvent event)
         {
            close();
         }
      });
      gridpane.add(login, 1, 3);
      GridPane.setHalignment(login, HPos.RIGHT);
      root.getChildren().add(gridpane);
   }
}
