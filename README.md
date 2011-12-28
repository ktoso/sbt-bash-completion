sbt - bash completion
=====================

This project is a simple bash completion script for the popular Scala build tool - Simple Build Tool (<a href="https://github.com/harrah/xsbt">SBT</a>).

Install
=======

To install the script, all you need to do is download it into your bash completion directory.
You'll need root provileges to do this.

```
cd /etc/bash_completion.d
sudo wget https://raw.github.com/ktoso/sbt-bash-completion/master/sbt
```

Tips
====

The script uses a cache called `.sbt_completion_cache`, so only the first time you use the completion it actually calls sbt (which is slow, as it has to start etc...)
If you know you did some changes which may change what `sbt tasks` contains, just delete this file - it'll get recreated when needed (using fresh values).

You may want to run the following command to ignore the completion cache, if you're in a git repository:

```
echo '.sbt_completion_cache' >> .gitignore
git commit .gitignore -m 'ignoring sbt completion cache'
```
