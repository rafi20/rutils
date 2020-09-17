# rutils

# to sync the changes on master to your working branch (when already some changes made to branch)
git stash
git pull --rebase origin master
git stash pop

git branch
git checkout <filename>
git status
git add fileName
git add 
git checkout -b rdm_20.3.1
git checkout -b RDM-2402
git commit -m "RDM-2402 added length >=, <= operators"
git commit -m "RDM-2402 renamed length check operator"
git push -u origin RDM-2547
git push -u origin RDM-2402

#delete remote branch
git push origin --delete feature/login
git push origin --delete remoteBranchName


#delete local branch
git branch -d feature/login
git branch -d localBranchName

