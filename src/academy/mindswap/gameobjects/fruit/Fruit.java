package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.snake.Snake;

public class Fruit {

    private Position fruitPosition;
    private Snake snake;

    public Fruit() {

    }

    public Position getPosition() {

        return this.fruitPosition;
    }
    public Position generatePosition() {

        Position snakeLocation = new Position(1, 1);
        Position fruitPosition = this.getRandomPosition();
        while (fruitPosition.equals(snakeLocation)) {
            for (int i = 0; i < snake.getSnakeSize(); i++) {
                snakeLocation = new Position(
                        snake.getFullSnake().get(i).getCol(),
                        snake.getFullSnake().get(i).getRow()
                );
            };
        }
        this.fruitPosition = fruitPosition;
        return fruitPosition;
    }


    public Position getRandomPosition() {
        int randomCols = (int) Math.floor(Math.random() * 98 + 3);
        int randomRows = (int) Math.floor(Math.random() * 23 + 3);
        return new Position(randomCols,randomRows);
    }

}
