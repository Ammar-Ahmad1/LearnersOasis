package Home;

import static org.junit.jupiter.api.Assertions.*;


import java.util.concurrent.CountDownLatch;


import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import org.junit.jupiter.api.Test;

class MainTest {

	  @Test
	    public void testA() throws InterruptedException {
	        Thread thread = new Thread(new Runnable() {

	            @Override
	            public void run() {
	                new JFXPanel(); // Initializes the JavaFx Platform
	                Platform.runLater(new Runnable() {

	                    @Override
	                    public void run() {
	                        try {
								new Main().start(new Stage());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

	                    }
	                });
	            }
	        });
	        thread.start();// Initialize the thread
	        //Thread.sleep(10000); // Time to use the app, with out this, the thread
	                                // will be killed before you can tell.
	    }

//	@SuppressWarnings( "restriction" )
	//public class JfxTestRunner extends BlockJUnit4ClassRunner
	//{
	  /**
	   * Creates a test runner, that initializes the JavaFx runtime.
	   *
	   * @param klass The class under test.
	   * @throws InitializationError if the test class is malformed.
	   */
	 /* public JfxTestRunner( final Class<?> klass ) throws InitializationError
	  {
	    super( klass );
	    try
	    {
	      setupJavaFX();
	    }
	    catch ( final InterruptedException e )
	    {
	      throw new InitializationError( "Could not initialize the JavaFx platform." );
	    }
	  }

	  private static void setupJavaFX() throws InterruptedException
	  {
	    final CountDownLatch latch = new CountDownLatch( 1 );

	    // initializes JavaFX environment
	    PlatformImpl.startup( () ->
	    {
	      /* No need to do anything here */
//	    } );

//	    latch.countDown();

//	    latch.await();
	//  }
//	}
}
