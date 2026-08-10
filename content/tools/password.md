---
title: "密码生成器"
linkTitle: "密码生成器"
subtitle: "本地生成强密码，不联网、不记录"
description: "在浏览器本地用密码学随机数生成强密码，可选字符集、排除易混淆字符、批量生成并显示熵值强度。"
date: 2026-08-10
draft: false
author: "noxue"
tags: ["密码", "安全", "小工具"]
categories: ["小工具"]
weight: 3
math: false
lightgallery: false
toc: false
---

注册海外账号最好每个站一个独立密码。这个页面用浏览器自带的密码学随机数（`crypto.getRandomValues`）在**你本机**生成，不联网、不上报、刷新就没了。

<!--more-->

{{< tool-password >}}

## 几点建议

- **长度比复杂度重要。** 16 位纯字母数字也比 8 位带符号的强得多，能用长的就用长的。
- **别自己记。** 用 iCloud 钥匙串、Bitwarden、1Password 这类密码管理器存，只记一个主密码。
- **排除易混淆字符** 适合需要手抄或电话报给客服的场景（0 和 O、1 和 l 分不清）。纯粘贴使用时关掉它能让密码更强一点。
- **有些网站不接受特殊符号**，遇到报错就把「符号」那一栏取消勾选再生成。
