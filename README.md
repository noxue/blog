# 不学网 · 使用手册

基于 [Hugo](https://gohugo.io/) + [DoIt](https://github.com/HEIGE-PCloud/DoIt) 主题，部署在 GitHub Pages，域名 **noxue.com**。
推送到 `main` 分支后，GitHub Actions 会自动构建并发布，**无需手动操作**。

---

## 目录

- [0. 快速开始（最常用）](#0-快速开始最常用)
- [1. 发布一篇文章](#1-发布一篇文章)
- [2. 选分类 / 打标签](#2-选分类--打标签)
- [3. 插入图片（含点击放大）](#3-插入图片含点击放大)
- [4. 代码 / 公式 / 提示框 / 流程图](#4-代码--公式--提示框--流程图)
- [5. 插入视频 / 音乐 / 链接卡片](#5-插入视频--音乐--链接卡片)
- [6. 打赏收款码](#6-打赏收款码)
- [7. 友情链接](#7-友情链接)
- [8. 评论](#8-评论)
- [9. 本地预览](#9-本地预览)
- [10. 常用配置位置](#10-常用配置位置)

---

## 0. 快速开始（最常用）

```bash
# 1. 新建文章（会在 content/posts/ 下生成模板）
hugo new posts/my-first-post.md

# 2. 用编辑器打开写内容，把 front matter 里的 draft: true 改成 false

# 3. 发布（推送后自动部署到 noxue.com，约 1-2 分钟生效）
git add -A
git commit -m "post: 我的第一篇文章"
git push
```

> 文件名就是网址的一部分：`my-first-post.md` → `https://noxue.com/posts/my-first-post/`
> 建议用**英文短横线**命名文件（中文标题写在 front matter 的 `title` 里）。

---

## 1. 发布一篇文章

文章都放在 **`content/posts/`** 目录，每篇是一个 `.md` 文件。

用命令生成（推荐，自动带好模板）：

```bash
hugo new posts/rust-tips.md
```

生成的文件顶部是 **front matter**（用 `---` 包起来的配置）：

```yaml
---
title: "Rust 的几个实用技巧"   # 文章标题
subtitle: ""                  # 副标题（可留空）
date: 2026-07-14T10:00:00+08:00
draft: true                   # ★ 写完改成 false 才会发布
author: "noxue"
tags: ["Rust", "技巧"]        # 标签
categories: ["编程"]          # 分类
featuredImage: ""             # 封面图（可留空）
math: false                   # 要写数学公式就改 true
lightgallery: true            # 图片点击放大
---

一句话摘要，会显示在文章列表里。

<!--more-->            ← 这行以上是"摘要"，以下是"正文"

## 正文小标题

正文内容……
```

要点：
- **`draft: true` 的文章不会发布**，写好后改成 `draft: false`。
- **`<!--more-->`** 之前的内容是列表页显示的摘要，之后是全文。
- 文件名用英文，标题用 `title` 字段写中文。

---

## 2. 选分类 / 打标签

在 front matter 里写：

```yaml
tags: ["Rust", "异步", "Tokio"]     # 标签，细粒度，可以多个
categories: ["编程"]                # 分类，粗粒度，通常 1 个
```

- **分类（categories）**：大类，比如 `编程` / `折腾` / `AI 摸鱼`。
- **标签（tags）**：具体关键词，比如 `Rust` / `Docker` / `Nginx`。
- 直接写新名字就会自动创建，**不需要预先定义**。
- 访客可在导航栏「分类」「标签」页面按此浏览。

---

## 3. 插入图片（含点击放大）

**方式 A：放全站图片目录（推荐）**

1. 把图片放到 `static/images/` 下（可自建子目录，如 `static/images/posts/`）。
2. 在文章里用**绝对路径**引用（不带 `static`）：

```markdown
![图片说明](/images/posts/架构图.png)
```

**方式 B：图片跟文章放一起（页面包）**

把文章建成目录形式 `content/posts/我的文章/index.md`，图片放同目录，然后：

```markdown
![图片说明](架构图.png)
```

> 已开启 **lightgallery**，正文图片**点击即可放大**浏览。
> 设封面图：front matter 里 `featuredImage: "/images/posts/封面.png"`。

---

## 4. 代码 / 公式 / 提示框 / 流程图

**代码高亮**（带行号、复制按钮）：

    ```go
    fmt.Println("Hello, 不学网!")
    ```

**数学公式**（需 front matter 里 `math: true`）：

```markdown
行内 \(E = mc^2\)，块级：
$$\int_{-\infty}^{\infty} e^{-x^2}\,dx = \sqrt{\pi}$$
```

**提示框 admonition**（彩色 callout）：

```markdown
{{</* admonition type="tip" title="小贴士" */>}}
这里是提示内容。
{{</* /admonition */>}}
```

`type` 可选：`note` `tip` `info` `warning` `danger` `success` `question` `failure` `quote` `example` `abstract` `bug`。
加 `open=false` 可默认折叠。

**流程图 Mermaid**：

    ```mermaid
    graph LR
        A[写文章] --> B[git push] --> C[自动部署] --> D((noxue.com))
    ```

---

## 5. 插入视频 / 音乐 / 链接卡片

**B站视频**：

```markdown
{{</* bilibili BV号 */>}}
```

**音乐**（网易云等）：

```markdown
{{</* music netease song 歌曲ID */>}}
```

**好看的链接卡片**：

```markdown
{{</* link "https://example.com" "标题" "描述" */>}}
```

---

## 6. 打赏收款码

文章底部的「请我喝咖啡」区域会显示微信/支付宝收款码。

**替换成你自己的收款码**：把两张图命名后覆盖到 `static/images/`：

```
static/images/reward-wechat.png    ← 微信收款码
static/images/reward-alipay.png    ← 支付宝收款码
```

（当前是占位图，换成真实二维码即可。建议正方形，160×160 以上。）

- 打赏文案/开关在 `config/_default/params.toml` 的 `[sponsor]` 里。
- 某篇文章不想显示打赏：该文 front matter 加 `sponsor: false`（可选）。

---

## 7. 友情链接

编辑 **`content/friends.md`**，每个友链一行：

```markdown
{{</* friend name="朋友的昵称" url="https://对方网址" avatar="对方头像URL" bio="一句话简介" */>}}
```

多个就写多行。保存后 `git push` 即可。导航栏「友链」可访问。

---

## 8. 评论

- **默认所有文章/页面都开启评论**（giscus，基于 GitHub 讨论），**不用写任何配置**。
- 读者用 GitHub 账号登录即可评论，评论存在 `noxue/blog` 仓库的 Discussions 里。
- **想关闭某页评论**：该页 front matter 加 `comment: false`。
  > ⚠️ 注意：**不要写 `comment: true`**（DoIt 的坑，反而会关掉评论）。开启保持默认即可。

---

## 9. 本地预览

推送前想先看效果：

```bash
hugo server -D          # -D 表示同时预览草稿
# 浏览器打开 http://localhost:1313/
```

改动会热更新，`Ctrl+C` 停止。

---

## 10. 常用配置位置

| 想改什么 | 文件 |
|----------|------|
| 站点标题 / 语言 / 域名 | `config/_default/hugo.toml` |
| 副标题 / 头像 / 社交图标 / 搜索 | `config/_default/params.zh-cn.toml` |
| 导航栏 logo、页脚、打赏、评论、Live2D 等 | `config/_default/params.toml` |
| 顶部导航菜单 | `config/_default/menu.zh-cn.toml` |
| 头像 | `assets/images/avatar.webp` |
| 网站图标 favicon / logo | `static/` 和 `static/images/logo.webp` |

**部署**：一切改动 `git push` 到 `main` 后自动构建发布，约 1-2 分钟生效于 https://noxue.com

---

## 备忘：这个博客已经配好的功能

代码高亮 · 全文搜索 · 深浅色切换 · 目录 · 阅读时长/字数 · giscus 评论 ·
不蒜子访问统计 · pangu 中文自动空格 · KaTeX 公式 · Mermaid 图表 ·
图片点击放大 · 打字机副标题 · Live2D 看板娘 · 打赏码 · 友链页 · PWA 离线访问 · RSS 订阅
