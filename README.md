# OverScrolls

(In progress...)

Originally, my goal was building an unique "pull-to-refresh" effects on Android. I thought it can I
animate by overscroll offsets. I was surprised that there is no method that would give it back
the size of overscroll. So I created a solution that able to report it.

# Demo

(comming soon)


# Concept

1. Create an OverScrollHelper which following do:
    - Handle the touch event and watch the scrolling on Y axis (or maybe X axis).
    - Introduce new states (overscroll-start, overscroll, overscroll-end)
    - Add a listener to callback when overscroll in progress.
    - Calculate overscroll size.

2. User OverScrollHelper on the common scrollable Android views:
    - ScrollView --> OverScrollScrollView
    - ListView --> OverScrollListView
    - ...

3. Implement some custom overscroll example.



## Why good this?
It's a practical tool if you want to build a custom:
- Pull to refresh
- Parallax scroll
- EdgeEffect

# Usage

(In progress...)

## Download

There is enough to download only the overscrolls-library which contains all neccessary files.

------

## TODO

- ....


## License
See the LICENSE file in the project root.