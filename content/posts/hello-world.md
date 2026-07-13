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

## 提示框 admonition

{{< admonition type="tip" title="小贴士" >}}
可以用 `note`、`tip`、`warning`、`danger`、`success`、`question`、`info` 等类型，做出各种彩色提示框。
{{< /admonition >}}

{{< admonition type="warning" title="注意" open=true >}}
写技术文章时，用提示框标出「坑」和「注意事项」，读者一眼就能看到。
{{< /admonition >}}

到这里，博客的骨架就立起来了 🚀
