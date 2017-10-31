import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BookTest extends Application {
    ArrayList<Book> BookTest = new ArrayList<Book>();
    Book book = new Book();
    Book[] arr = BookTest.toArray(new Book[BookTest.size()]);
    Queue BookQueue = new Queue(arr, 0, 0);
    Queue obj = new Queue();

    Button btMain = new Button("Main Menu");
    Button btNewBook = new Button("Add New Book");
    Button btExistBook = new Button("Delete Book");
    Button btFindBook = new Button("Find Book");

	/*
	 * The primary stage for the javafx
	 *
	 * @params: Stage primaryStage
	 * return: NONE
	 */
    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        Button btGoTo = new Button("Go to Book Page");
        Button btEnd = new Button("Exit ");

        hbox.getChildren().add(btGoTo);
        hbox.getChildren().add(btEnd);

        HBox ImgBox = new HBox();
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.CENTER);
        borderPane.setTop(ImgBox);
        BorderPane.setAlignment(ImgBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 500, 550);
        primaryStage.setTitle("Library Menu");
        Image image = new Image("LibraryShelf.jpg");
        ImgBox.getChildren().add(new ImageView(image));
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

		/*
		 * Description: The second stage with all buttons
		 *
		 * @params: EventHandler<ActionEvent>, ActionEvent event
		 * return: NONE
		 */
        btGoTo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();

                HBox hbox1 = new HBox();
                hbox1.setSpacing(10);
                hbox1.setAlignment(Pos.CENTER);
                hbox1.getChildren().add(btNewBook);
                hbox1.getChildren().add(btExistBook);
                hbox1.getChildren().add(btFindBook);
                hbox1.getChildren().add(btMain);
                hbox1.getChildren().add(btEnd);

                HBox BookImg = new HBox();
                BorderPane borderPane1 = new BorderPane();
                borderPane1.setBottom(hbox1);
                BorderPane.setAlignment(hbox1, Pos.CENTER);
                borderPane1.setTop(BookImg);
                BookImg.setAlignment(Pos.TOP_CENTER);

                Scene scene1 = new Scene(borderPane1, 700, 300);
                primaryStage.setTitle("Book Menu");
                Image image1 = new Image("Main.jpg");
                BookImg.getChildren().add(new ImageView(image1));
                primaryStage.setScene(scene1);
                primaryStage.centerOnScreen();
                primaryStage.show();

            }
        });

		/*
		 * Description: New Book button
		 *
		 * @params: EventHandler<ActionEvent>
		 * return: NONE
		 */
        btNewBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();

                HBox hbox31 = new HBox();
                Scene scene31 = new Scene(hbox31, 1200, 100);
                primaryStage.setTitle("Add Book");
                primaryStage.setScene(scene31);

                final TextField bookISBN = new TextField();
                final TextField bookTitle = new TextField();
                final TextField bookAuthor = new TextField();
                final TextField bookYear = new TextField();

                bookISBN.setPromptText("ISBN");
                bookTitle.setPromptText("Title");
                bookAuthor.setPromptText("Author");
                bookYear.setPromptText("Year");

                bookISBN.setPrefColumnCount(15);
                bookISBN.getText();
                hbox31.getChildren().add(bookISBN);

                bookTitle.setPrefColumnCount(15);
                bookTitle.getText();
                hbox31.getChildren().add(bookTitle);

                bookAuthor.setPrefColumnCount(15);
                bookAuthor.getText();
                hbox31.getChildren().add(bookAuthor);

                bookYear.setPrefColumnCount(15);
                bookYear.getText();
                hbox31.getChildren().add(bookYear);

                Button addBook = new Button("Add Book");
                hbox31.getChildren().add(addBook);

                Button clear = new Button("Clear");
                hbox31.getChildren().add(clear);
                hbox31.getChildren().add(btMain);

            /*
             * Description: Clear button
             *
             * @params: EventHandler<ActionEvent>
             * return: NONE
             */
                clear.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        bookISBN.clear();
                        bookTitle.clear();
                        bookAuthor.clear();
                        bookYear.clear();
                    }
                });


                primaryStage.centerOnScreen();
                primaryStage.show();

            /*
             * Description: Add Book button
             *
             * @params: EventHandler<ActionEvent>, ActionEvent e
             * return: NONE
             */
                addBook.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        if ((bookISBN.getText() != null && !bookISBN.getText().isEmpty())) {
                            System.out.println("The Book: " + bookISBN.getText() +
                                    " " + bookTitle.getText() + "\nBook ID: " +
                                    bookAuthor.getText() + "\nBook Age: " +
                                    bookYear.getText() + " has been added");
                            Book Book = new Book(bookAuthor.getText(), bookISBN.getText(), bookTitle.getText(), bookYear.getText());
                            BookTest.add(Book);
                            Queue BookQueue = new Queue(arr, 0, 0);
                            BookQueue.enqueue(arr, Book);
                            obj.enqueue(arr, Book);


                        } else {
                            System.out.println("You did not add any Book.");
                        }

                    }
                });

            }
        });

		/*
		 * Description: Delete Book button
		 *
		 * @params: EventHandler<ActionEvent>
		 * return: NONE
		 */
        btExistBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox hbox3 = new HBox();
                Scene scene30 = new Scene(hbox3, 1200, 100);
                primaryStage.setTitle("Delete Book");
                primaryStage.setScene(scene30);

                final TextField bookISBN = new TextField();
                final TextField bookTitle = new TextField();
                final TextField bookAuthor = new TextField();
                final TextField bookAge = new TextField();

                bookISBN.setPromptText("ISBN");
                bookTitle.setPromptText("Title");
                bookAuthor.setPromptText("Author");
                bookAge.setPromptText("Year Published");

                bookISBN.setPrefColumnCount(15);
                bookISBN.getText();
                hbox3.getChildren().add(bookISBN);

                bookTitle.setPrefColumnCount(15);
                bookTitle.getText();
                hbox3.getChildren().add(bookTitle);

                bookAuthor.setPrefColumnCount(15);
                bookAuthor.getText();
                hbox3.getChildren().add(bookAuthor);

                bookAge.setPrefColumnCount(15);
                bookAge.getText();
                hbox3.getChildren().add(bookAge);

                Button deleteBook = new Button("Delete Book");
                hbox3.getChildren().add(deleteBook);

                Button clear = new Button("Clear");
                hbox3.getChildren().add(clear);

                hbox3.getChildren().add(btMain);

            /*
             * Description: Clear button
             *
             * @params: EventHandler<ActionEvent>
             * return: NONE
             */
                clear.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        bookISBN.clear();
                        bookTitle.clear();
                        bookAuthor.clear();
                        bookAge.clear();
                    }
                });


                primaryStage.centerOnScreen();
                primaryStage.show();

            /*
             * Description: Delete Book loop
             *
             * @params: EventHandler<ActionEvent>
             * return: NONE
             */
                deleteBook.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {


                        if ((!bookISBN.equals(null))) {
                            for (int i = 0; i < BookTest.size(); i++) {
                                if ((bookISBN.getText().equalsIgnoreCase(BookTest.get(i).getBookTitle()))) {
                                    BookTest.remove(i);
                                    System.out.println("The Book " + bookISBN.getText() + " has been removed");
                                    Queue BookQueue = new Queue(arr, 0, 0);

                                    obj.dequeue(arr, book);
                                } else if (bookISBN.getText().equalsIgnoreCase(BookTest.get(i).getBookTitle())) {
                                    System.out.println("Book not found");
                                }
                            }
                        } else {
                            System.out.println("Book not found.");
                        }
                    }
                });


            }
        });


		/*
		 * Description: Find Book button
		 *
		 * @params: EventHandler<ActionEvent>
		 * return: NONE
		 */
        btFindBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox hbox5 = new HBox();
                Scene scene5 = new Scene(hbox5, 1200, 100);
                primaryStage.setTitle("Enter Book's Information");
                primaryStage.setScene(scene5);

                final TextField bookISBN = new TextField();
                final TextField bookTitle = new TextField();
                final TextField bookAuthor = new TextField();
                final TextField bookAge = new TextField();

                bookISBN.setPromptText("ISBN");
                bookTitle.setPromptText("Title");
                bookAuthor.setPromptText("Author");
                bookAge.setPromptText("Year Published");

                bookISBN.setPrefColumnCount(15);
                bookISBN.getText();
                hbox5.getChildren().add(bookISBN);

                bookTitle.setPrefColumnCount(15);
                bookTitle.getText();
                hbox5.getChildren().add(bookTitle);

                bookAuthor.setPrefColumnCount(15);
                bookAuthor.getText();
                hbox5.getChildren().add(bookAuthor);

                bookAge.setPrefColumnCount(15);
                bookAge.getText();
                hbox5.getChildren().add(bookAge);

                Button findBook = new Button("Find Book");
                hbox5.getChildren().add(findBook);

                Button clear = new Button("Clear");
                hbox5.getChildren().add(clear);

                hbox5.getChildren().add(btMain);

				/*
				 * Description: Clear button
				 *
				 * @params: EventHandler<ActionEvent>
				 * return: NONE
				 */

                clear.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        bookISBN.clear();
                        bookTitle.clear();
                        bookAuthor.clear();
                        bookAge.clear();
                    }
                });

                primaryStage.centerOnScreen();
                primaryStage.show();

				/*
				 * Description: Find Book loop
				 *
				 * @params: EventHandler<ActionEvent>
				 * return: NONE
				 */
                findBook.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {

                        if ((bookISBN.getText() != null && !bookISBN.getText().isEmpty())) {
                            for (int i = 0; i < BookTest.size(); i++){
                                if((bookISBN.getText().equalsIgnoreCase(BookTest.get(i).getBookTitle()))){
                                    System.out.println("Book found at " +(i+1));
                                }else {
                                    System.out.println("Book not found");
                                }

                            }
                        } else {
                            System.out.println("Book not found.");
                        }
                    }
                });
            }
        });

		/*
		 * Description: Exit button
		 *
		 * @params: EventHandler<ActionEvent>
		 * return: NONE
		 */
        btEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.centerOnScreen();
                primaryStage.close();

            }
        });

        btMain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Books");
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.show();
            }
        });
    }

    //Main method
    public static void main(String []args){
        launch(args);
    }
}