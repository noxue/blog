---
title: "在线 Unicode 转义转换：中文与 \\u 转义序列双向互转"
subtitle: "支持 \\u 和 \\x，接口里的乱码一键还原"
date: 2026-08-11T08:22:00+08:00
draft: false
author: "noxue"
tags: ["Unicode", "转义", "开发工具"]
categories: ["小工具"]
featuredImage: "cover.png"
math: false
lightgallery: true
---

接口返回或日志里出现一串 `不学网` 看不懂？其实解码回来就是中文。**不学网工具箱** 的 [Unicode 转义](https://tools.noxue.com/unicode/) 让中文和 `\u` 转义序列一键互转。

<!--more-->

## 用途

- **中文 → \\u 转义**：把中文写进只认 ASCII 的配置、源码字符串时更保险。
- **\\u 转义 → 中文**：把 `\u` 开头的一串还原成可读文字，排查「中文变转义」类乱码。
- **兼容 \\x**：解码同时识别 `\uXXXX` 和 `\xXX`；BMP 以外的 Emoji 由代理对表示，也能还原。
- **纯本地**：浏览器里算，内容不上传。

## 第一步：粘内容，选方向

把中文或 `\u` 转义串粘进去，选转换方向。

![Unicode 转义工具的输入区：方向选择（中文→\u / \u→中文）与输入框](step1-input.png "① 选方向，粘上中文或 \\u 转义串")

## 第二步：拿结果

下面实时出结果，点复制即可。

![Unicode 转义结果：中文被转成 \u 开头的转义序列](step2-output.png "② 中文与 \\u 转义实时互转")

{{< admonition type="note" title="\\u 是哪来的" open=true >}}
`\u` 后跟 4 位十六进制码点，是 JavaScript、JSON、Java 等语言表示字符的写法。有些系统会把中文自动存成这种转义形式。
{{< /admonition >}}

工具地址：**[https://tools.noxue.com/unicode/](https://tools.noxue.com/unicode/)**
