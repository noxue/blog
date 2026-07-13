---
title: "搭建这个博客：Hugo + DoIt 实战"
subtitle: ""
date: 2026-07-13T20:30:00+08:00
draft: false
author: "noxue"
tags: ["Hugo", "DoIt", "建站"]
categories: ["折腾"]
featuredImage: ""
---

用 Hugo + DoIt 搭建技术博客，记录一下起点与关键配置。

<!--more-->

## 为什么选 Hugo

- **快**：单个 Go 二进制，几百篇文章毫秒级构建。
- **无运行时依赖**：不需要 Node / Ruby。

## 代码高亮

```go
package main

import "fmt"

func main() {
    fmt.Println("Hello, 不学网!")
}
```

## 数学公式

块级公式：

$$\int_{-\infty}^{\infty} e^{-x^2}\,dx = \sqrt{\pi}$$

到这里，博客的骨架就立起来了 🚀
