# rutils

git commit -m "readme updated"
git push -u origin master

# to sync the changes on master to your working branch (when already some changes made to branch)
git stash
git pull --rebase origin master
git stash pop

git branch
git checkout <filename>
git status
git add fileName
git add 
git checkout -b branch_name1
git checkout -b branch_name1
git commit -m "message 1"
git commit -m "message 2"
git push -u origin branch_name
git push -u origin branch_name

#delete remote branch
git push origin --delete feature/login
git push origin --delete remoteBranchName


#delete local branch
git branch -d feature/login
git branch -d localBranchName

