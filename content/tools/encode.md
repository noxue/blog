---
title: "编码解码 / 哈希"
linkTitle: "编码 / 哈希"
subtitle: "Base64、URL、HTML、Unicode 编解码与 MD5 / SHA 哈希"
description: "一个页面搞定 Base64、Base64 URL、URL 编码、HTML 实体、Unicode 转义的双向转换，以及 MD5 / SHA-1 / SHA-256 / SHA-384 / SHA-512 哈希。"
date: 2026-08-10
draft: false
author: "noxue"
tags: ["Base64", "编码", "哈希", "开发", "小工具"]
categories: ["小工具"]
weight: 7
math: false
lightgallery: false
toc: false
---

Base64、URL 编码、HTML 实体、Unicode 转义、MD5 / SHA 哈希，全部在本地完成，内容不会发到服务器。中文和 emoji 都按 UTF-8 正确处理。

<!--more-->

{{< tool-encode >}}

## 常见用途

- **Base64**：把图片、证书塞进 JSON 或配置文件里；看懂 JWT 的前两段。
- **Base64 URL**：和普通 Base64 的区别是把 `+` `/` 换成 `-` `_` 并去掉尾部 `=`，用在 URL 和 JWT 里。
- **URL 编码**：查询参数里带中文、空格、`&` 时必须编码，对应 JS 的 `encodeURIComponent`。
- **HTML 实体**：把用户输入的 `<script>` 变成纯文本显示，防 XSS。
- **哈希**：校验下载的文件有没有被改过（对比官网给的 SHA-256），或者看密码库泄露里的哈希类型。

{{< admonition type="warning" title="别用 MD5 存密码" open=true >}}
MD5 和 SHA-1 都已经不安全了，只适合做文件完整性校验。存密码要用 bcrypt、scrypt 或 Argon2 这类专门的慢哈希。
{{< /admonition >}}
