---
title: "Rust 异步入门：async/await 到底怎么跑起来的"
date: 2026-07-10T14:00:00+08:00
author: "noxue"
tags: ["Rust", "异步", "Tokio"]
categories: ["编程"]
---

从 Future 到 Executor，理解 Rust 异步运行时的核心机制。

<!--more-->

Rust 的 `async fn` 返回一个实现了 `Future` 的状态机，真正的调度由运行时（如 Tokio）完成。

```rust
#[tokio::main]
async fn main() {
    let r = fetch().await;
    println!("{r}");
}
```
