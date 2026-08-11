---
title: "在线 MD5 / SHA 哈希计算：文本即时算摘要，用于文件校验"
subtitle: "MD5、SHA-1/256/384/512，大小写可切换，本地运算"
date: 2026-08-11T08:30:00+08:00
draft: false
author: "noxue"
tags: ["MD5", "SHA256", "哈希", "开发工具"]
categories: ["小工具"]
featuredImage: "cover.png"
math: false
lightgallery: true
---

想快速算一段文本的 MD5、SHA-256？或者核对下载文件官网给的校验值？**不学网工具箱** 的 [MD5 / SHA 哈希计算](https://tools.noxue.com/hash/) 输入即出摘要，支持 MD5 和 SHA 全家，大小写随切，全程在本地。

<!--more-->

## 支持

- **五种算法**：MD5、SHA-1、SHA-256、SHA-384、SHA-512。
- **大小写切换**：十六进制结果要大写还是小写，一键切。
- **即时计算**：边输入边出结果。
- **纯本地**：用浏览器自带的 Web Crypto 计算，内容不上传。

## 第一步：选算法，输入内容

选一个算法（默认 MD5），设好大小写，把要算的文本粘进去。

![哈希工具的算法选择区：MD5/SHA-1/256/384/512 与大小写切换](step1-algo.png "① 选算法、设大小写")

## 第二步：拿摘要

下面实时出十六进制摘要，点「复制结果」即可。

![哈希计算结果：一串十六进制摘要，带复制按钮](step2-output.png "② 摘要实时生成，可复制")

{{< admonition type="warning" title="别用 MD5 / SHA 存密码" open=true >}}
MD5、SHA-1 已经不安全，只适合做完整性校验。存密码要用带盐、慢速的 bcrypt、scrypt 或 Argon2。
{{< /admonition >}}

配套：需要 Base64 编解码用 [Base64 编解码](https://tools.noxue.com/base64/)。

工具地址：**[https://tools.noxue.com/hash/](https://tools.noxue.com/hash/)**
