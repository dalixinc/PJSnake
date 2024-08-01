import pygame, sys

pygame.init()
screen = pygame.display.set_mode((400, 500))
clock = pygame.time.Clock()
test_surface = pygame.Surface((100, 200))
x = 200

while True:
    # DRAW OBJECTS
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    screen.fill(pygame.Color('yellow'))
    x += 1
    screen.blit(test_surface, (x, 250))
    test_surface.fill(pygame.Color('red'))
    pygame.display.update()
    clock.tick(60)

