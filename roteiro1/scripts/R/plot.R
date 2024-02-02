# Se o pacote não tiver instalado na máquina.
#install.packages('ggplot2', repos = "http://cran.us.r-project.org")

library('ggplot2')

args <- commandArgs()

data = read.table(args[1], header = T)
ggplot(data, aes(x = `sample`, y = time, coour = alg)) + geom_line()
