public class MainBall {
    public static void main(String[] args){
        BallPanel ballPanel = new BallPanel();
        BallController ballController = new BallController(ballPanel);
        BallUI bouncingBalls = new BallUI(ballController, ballPanel);
        bouncingBalls.createAndShowUI();
    }
}
