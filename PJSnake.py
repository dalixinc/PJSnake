import pygame, sys
from pygame.math import Vector2

class APPLE:
    def __init__(self):
        self.x = 5
        self.y = 4
        self.pos = Vector2(self.x, self.y)

    def draw_apple(self):
        apple_rect = pygame.Rect(self.pos.x, self.pos.y, cell_size, cell_size)
        pygame.draw.rect(screen, (126, 166, 114),apple_rect)

pygame.init()
cell_size = 40
cell_number = 20
screen = pygame.display.set_mode((cell_number * cell_size, cell_number * cell_size))
clock = pygame.time.Clock()

apple = APPLE()

while True:
    # DRAW OBJECTS
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    screen.fill(pygame.Color((175, 215, 70)))
    apple.draw_apple()

    pygame.display.update()
    clock.tick(60)

