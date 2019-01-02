# Git Command

## Common Operation

```bash
#!/bin/bash

# help
git help

# add
git add -A .

# commit
git commit -m "comments"

# list branch
git branch

# create <branch>
git branch <branch>

# delete <branch> saftly
git branch -d <branch>  

# force to delete <branch>
git branch -D <branch>

# rename <branch>
git branch -m <branch>

# checkout <branch>
git checkout <existing-branch> //切换到一个已有分支上
git checkout -b <new-branch> // -b 标记 可以方便让你先创建一个新的new-branch,再直接切换过去
git checkout -b <new-branch> <existing-branch> //在已有的分支上创建分支，原来的分支使新分支的基
git clone -b v1.16.1 https://github.com/grpc/grpc-java

# merge <branch>
git merge <branch>  //将指定分支并入当前分支
git merge --no-ff <branch>  //将指定分支并入当前分支，但 总是 生成一个合并提交（即使是快速向前合并）。这可以用来记录仓库中发生的所有合并。

# push
git push origin master:master
```

## git branch development diagram

### git development diagram

```bash
#!/bin/bash
# 开始新功能
git checkout -b new-feature master

# 编辑文件
git add <file>
git commit -m "开始新功能"

# 在master分支上开发
git checkout master

# 编辑文件
git add <file>
git commit -m "在master上添加了一些极其稳定的功能"

# 合并new-feature分支
git merge new-feature
git branch -d new-feature
```

## Advanced Operation

```bash
#!/bin/bash

#Get and set repository or global options
git config --edit --global

# remote URL
git config --get remote.origin.url

#与服务器端做比较
git diff --stat local_branch origin/remote_branch
git diff --stat master origin/master

# git push without input user and password

git config --global credential.helper cache
[Caching github password](https://help.github.com/articles/caching-your-github-password-in-git)

```