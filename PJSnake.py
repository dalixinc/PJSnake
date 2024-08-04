import pygame, sys, random
from pygame.math import Vector2

class MAIN:
    def __init__(self):
        # CREATE OBJECTS
        self.snake = SNAKE()
        self.apple = APPLE()

    def update(self):
        self.snake.move_snake()
        self.check_collision()

    def draw(self):
        self.apple.draw_apple()
        self.snake.draw_snake()

    def check_collision(self):
        if self.apple.pos == self.snake.body[0]:
            print('Schnacking')

class SNAKE:
    def __init__(self):
        self.body = [Vector2(5,10), Vector2(6,10), Vector2(7,10)]
        self.direction = Vector2(1, 0)

    def draw_snake(self):
        for block in self.body:
            snake_rect = pygame.Rect(int(block.x * cell_size), int(block.y * cell_size), cell_size, cell_size)
            pygame.draw.rect(screen, (183, 121, 122), snake_rect)

    def move_snake(self):
        # Need a copy of the array (or list, as it is called in python)
        body_copy = self.body[:-1] # Slicing - drop the last element
        body_copy.insert(0, body_copy[0] + self.direction) # vector mathematics
        self.body = body_copy[:] # move it back to the snake body

class APPLE:
    def __init__(self):
        self.x = random.randint(0, cell_number -1)
        self.y = random.randint(0, cell_number -1)
        self.pos = Vector2(self.x, self.y)

    def draw_apple(self):
        apple_rect = pygame.Rect(int(self.pos.x * cell_size), int(self.pos.y * cell_size), cell_size, cell_size)
        pygame.draw.rect(screen, (126, 166, 114), apple_rect)

# INITIALISE GAME
pygame.init()
cell_size = 40
cell_number = 20
screen = pygame.display.set_mode((cell_number * cell_size, cell_number * cell_size))
clock = pygame.time.Clock()

SCREEN_UPDATE = pygame.USEREVENT
pygame.time.set_timer(SCREEN_UPDATE, 150)

main_game = MAIN()

# GAME LOOP
while True:
    # DRAW OBJECTS
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == SCREEN_UPDATE:
            main_game.update()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP:
                main_game.snake.direction = Vector2(0, -1)
            if event.key == pygame.K_DOWN:
                main_game.snake.direction = Vector2(0, 1)
            if event.key == pygame.K_LEFT:
                main_game.snake.direction = Vector2(-1, 0)
            if event.key == pygame.K_RIGHT:
                main_game.snake.direction = Vector2(1, 0)

    screen.fill(pygame.Color((175, 215, 70)))
    main_game.draw()
    pygame.display.update()
    clock.tick(60)

