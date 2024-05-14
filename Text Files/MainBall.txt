// Main to test 
public class MainBall {
    public static void main(String[] args) {
        BallController ballController = new BallController();
        BallUI bouncingBalls = new BallUI(ballController);
        bouncingBalls.createAndShowUI();
    }
}

