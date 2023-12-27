gb_ivan@gbserver:~$ history

    1  sudo apt update
    3  sudo apt upgrade
 ..................
  421  cd GB
  422  mkdir HomeWork396437
  423  cd HomeWork396437
  424  ll
  425  ls
......
  446  mysql
  447  sudo apt updatesudo apt list --upgradable
  448  sudo apt update
  449  sudo apt list --upgradable # получить список обновлений
  450  sudo apt upgrade
  451  wget https://dev.mysql.com/get/mysql-apt-config_0.8.20-1_all.deb
  452  sudo dpkg -i mysql-apt-config_0.8.20-1_all.deb
  453  sudo apt update
.......
  460  cd ~
  461  sudo rm -rf /etc/mysql /var/lib/mysql
  462  sudo apt-get autoremove
  463  sudo apt-get autoclean
  464  curl -OL https://dev.mysql.com/get/mysql-apt-config_0.8.12-1_all.deb
  465  sudo dpkg -i mysql-apt-config*
  466  sudo apt update
  467  sudo apt install mysql-server -y
  468  dpkg -i mysql-apt-config_0.8.13-1_all.deb
  469  sudo dpkg -i mysql-apt-config_0.8.13-1_all.deb
  471  sudo apt update
  472  sudo systemctl status mysql.service
  473  cd  ~/GB/HomeWork396437

  474  cat > "Домашние животные" <<EOL
  475  'Fido', Dog', '2020-01-01', 'Sit, Stay, Fetch'
  476  'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'
  477  'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'
  478  'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'
  479  'Smudge', 'Cat', '2020-02-20, 'Sit, Pounce, Scratch'
  480  'Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'
  481  'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'
  482  'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump'
  483  EOL

  484  cat > "Вьючные животные" <<EOL
  485  'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'
  486  'Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'
  487  'Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'
  488  'Storm', 'Horse', '2014-05-05', 'Trot, Canter'
  489  'Dune', 'Camel', '2018-12-12', 'Walk, Sit'
  490  'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'
  491  'Blaze', 'Horse', 2016-02-29', 'Trot, Jump, Gallop'
  492  'Sahara', 'Camel', '2015-08-14', 'Walk, Run'
  493  EOL

  494  cat "Домашние животные" "Вьючные животные" > "Друзья человека"
  495  cat "Друзья человека"
  496  mv "Друзья человека" "Result/"
  497  ls ./Result
  498  tree
  499  ls

  503  sudo dpkg -l cowsay

  505  wget http://archive.ubuntu.com/ubuntu/pool/universe/c/cowsay/cowsay_3.03+dfsg2-4_all.deb
  506  ls -l *.deb
  508  sudo dpkg -i cowsay_3.03+dfsg2-4_all.deb
  509  cowsay -f turkey "Well, I am a talking turkey!"
  516  sudo dpkg -r cowsay
  517  cowsay -f turkey "Well, I am a talking turkey!"
  518  clear
  519  history

