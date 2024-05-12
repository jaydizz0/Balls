public class MainBall {
    public static void main(String[] args) {
        BallController ballController = new BallController();
        BallPanel ballPanel = new BallPanel(ballController);
        BallUI bouncingBalls = new BallUI(ballController, ballPanel);
        bouncingBalls.createAndShowUI();
    }
}

