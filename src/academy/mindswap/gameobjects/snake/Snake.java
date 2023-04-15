package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive;
    private Position head;
    private Position tail;


    LinkedList<Position> snakeBody;
    public Snake(Direction direction){
        this.direction = direction;
        snakeBody= new LinkedList<>();
        this.head = new Position(10,10);
        snakeBody.add(head);
        for (int i = 1; i <getSnakeSize(); i++){
            snakeBody.add(i, new Position(10-i, 10));
        }
        this.tail = snakeBody.getLast();
        this.alive = true;
    }

    public void increaseSize() {

        snakeBody.addLast(new Position(tail.getCol(), tail.getRow()));
                }

    public void move(Direction direction) {


        if(direction == Direction.UP && this.direction == Direction.DOWN) return;
        if(direction == Direction.DOWN && this.direction == Direction.UP) return;
        if(direction == Direction.RIGHT && this.direction == Direction.LEFT) return;
        if(direction == Direction.LEFT && this.direction == Direction.RIGHT) return;
        else{

        this.direction = direction;

            switch (direction) {
                case STOP:
                    break;
                case DOWN:
                    snakeBody.addFirst(new Position(head.getCol(), head.getRow() + 1));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case UP:
                    snakeBody.addFirst(new Position(head.getCol(), head.getRow() - 1));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case LEFT:
                    snakeBody.addFirst(new Position(head.getCol() - 1, head.getRow()));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
                case RIGHT:
                    snakeBody.addFirst(new Position(head.getCol() + 1, head.getRow()));
                    head = snakeBody.getFirst();
                    snakeBody.removeLast();
                    tail = snakeBody.getLast();
                    break;
            }

            }
        }


    public void move(){
        move(direction);
    }

    public void die() {
        alive = false;
        this.direction = Direction.STOP;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return head;
    }

    public Position getTail() {
        return tail;
    }

    public LinkedList<Position> getFullSnake(){
        return snakeBody;
    }

    public int getSnakeSize() {
        return SNAKE_INITIAL_SIZE ;
    }

    public boolean checkBodyCollision() {
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(i).equals(getHead())) {
                return true;
            }
        }
        return false;

    }
}

