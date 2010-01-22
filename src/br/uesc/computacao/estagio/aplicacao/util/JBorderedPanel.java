package br.uesc.computacao.estagio.aplicacao.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class JBorderedPanel extends JPanel 
{

	/**
	 * Inútil para mim.
	 */
	private static final long serialVersionUID = 1L;
	private int borderThickness = 2;
	private int borderMargin = 1;
	private Dimension titleBorderDimension = new Dimension();
	private Point titleBorderLocation = new Point();
	private Dimension contentBorderDimension = new Dimension();
	private Point contentBorderLocation = new Point();
	private JLabel title = new JLabel("Test");
	private JSeparator uTitleBorder = new JSeparator();
	private JSeparator lTitleBorder = new JSeparator();
	private JSeparator bTitleBorder = new JSeparator();
	private JSeparator rTitleBorder = new JSeparator();
	private JSeparator uContentBorder = new JSeparator();
	private JSeparator sContentBorder = new JSeparator();
	private JSeparator lContentBorder = new JSeparator();
	private JSeparator rContentBorder = new JSeparator();
	private JSeparator bContentBorder = new JSeparator();
	private int titleDistance = 3;
	private boolean titlePosition = false;
	
	public void initalizeBorders() 
	{
		setTitleBorderDimension();
		setTitleBorderLocation();
		setContentBorderDimension();
		setContentBorderLocation();
		drawTitleBorder();
		drawPanelBorder();
	}
	
	private void setTitleBorderDimension() {
		titleBorderDimension = new Dimension();
		titleBorderDimension.height = title.getSize().height + 
			2*(borderThickness + borderMargin);
		titleBorderDimension.width = title.getSize().width + 
			2*(borderThickness + borderMargin);
	}
	
	private void setTitleBorderLocation() {
		titleBorderLocation.x = title.getLocation().x -
			(borderThickness + borderMargin);
		titleBorderLocation.y = title.getLocation().y -
			(borderThickness + borderMargin);
	}
	
	private void setContentBorderDimension() {
		if(titlePosition){
			contentBorderDimension.height = this.
				getSize().height - borderThickness;
			contentBorderDimension.width = this.
				getSize().width - 
				(titleBorderDimension.width/2 + borderThickness);
		}
		else {
			contentBorderDimension.height = this.
				getSize().height - (titleBorderDimension.height/2 + borderThickness);
			contentBorderDimension.width = this.
				getSize().width -borderThickness;
		}
		
	}
	
	private void setContentBorderLocation() {
		if(titlePosition){
			contentBorderLocation.x = titleBorderDimension.width/2;
			contentBorderLocation.y = 0;
		}
		else {
			contentBorderLocation.x = 0;
			contentBorderLocation.y = titleBorderDimension.height/2;
		}
		
	}
	
	/**
	 * Cria um novo BorderedPanel
	 * @param title O título do Panel
	 * @param titlePosition false = horizontal, true = 
	 * vertical
	 * @param size Dimension, com o tamanho do JPanel.
	 * @param titleDistance distancia do vértice superior 
	 * esquerdo até o título.
	 * 
	 */
	public JBorderedPanel(JLabel title, boolean 
			titlePosition, Dimension size,
			int titleDistance)
	{
		super(null);
		this.setSize(size);
		this.titlePosition = titlePosition;
		this.setDistance(titleDistance);
		this.setTitle(title);
	}
	/**
	 * Cria um novo BorderedPanel
	 * @param title O título do Panel
	 * @param titlePosition false = horizontal, true = vertical 
	 * @param  
	 */
	public JBorderedPanel(String title, boolean titlePosition,
			int height, int width, int titleDistance)
	{
		this(new JLabel(title), titlePosition, 
				new Dimension(height, width), titleDistance);
	}
	
	public void setSize(int width, int height) 
	{
		if(checkPanelSize(width, height)){
			System.out.println(
				"O tamanho do painel é menor do que" +
				"o tamanho do título!");
			return;
		}
		super.setSize(width, height);
	}
	/**
	 * Dadas as larguras e alturas, do title e panel 
	 * nessa ordem, pode determinar se o título é
	 * maior ou igual ao painel no layout correto.
	 * @param panelWidth largura do painel
	 * @param panelheight altura do painel
	 * @param titleWidth largura do titulo
	 * @param titleheight altura do titulo
	 * @return true se é maior, false se é menor
	 */
	public boolean checkSizes(int panelWidth,
			int panelheight, int titleWidth, int titleheight)
	{
		if(titlePosition)
		{
			if(titleheight + titleDistance > panelheight)
				return true;
		}
		else if(titleWidth + titleDistance > panelWidth)
			return true;
		return false;
	}
	public boolean checkPanelSize(int panelWidth,
			int panelheight)
	{
		return checkSizes(panelWidth, panelheight, 
				title.getPreferredSize().width,
				title.getPreferredSize().height);
	}
	public boolean checkTitleSize(int titleWidth,
			int titleHeigth)
	{
		return checkSizes(
				this.getWidth(), this.getHeight(), 
				titleWidth,
				titleHeigth);
	}
	public void setTitleLocation()
	{
		if(titlePosition)title.setLocation(borderThickness +
				borderMargin, getTitleDistance());
		else title.setLocation(getTitleDistance(), 
				borderThickness + borderMargin);
	}
	
	public String getTitle() {
		return title.getText();
	}
	public void setTitle(JLabel title) {
		if(checkTitleSize(title.getPreferredSize().width,
				title.getPreferredSize().height))
		{
			System.out.println("Erro, tamanho do título " +
					"com o TitleDistance é maior que o tamanho" +
					" do painel!");
			return;
		}
		this.title = title;
		this.title.setSize(this.title.getPreferredSize());
		setTitleLocation();
		this.add(title);
	}

	public int getTitleDistance() {
		return titleDistance;
	}
	public void setDistance(int titleDistance) {
		if(titlePosition)
		{
			if(titleDistance > this.getHeight())
				System.out.println("Erro, o tamanho do " +
						"TitleDistance é maior que a" +
						" altura do painel!");
		}
		else if(titleDistance > this.getWidth())
		{
			System.out.println("Erro, o tamanho do Title" +
					"Distance é maior que a " +
					"largura do painel!");
		}
		this.titleDistance = titleDistance;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		initalizeBorders();
		drawBorders();
		super.paintComponent(g);
	}
	
	@Override
	public void setVisible(boolean flag) {
		initalizeBorders();
		drawBorders();
		super.setVisible(flag);
	}
	
	private void drawBorders() {
		drawPanelBorder();
		drawTitleBorder();
	}
	private void drawPanelBorder() {
		drawUpperPanelBorder();
		drawLeftPanelBorder();
		drawRightPanelBorder();
		drawLowerPanelBorder();
	}
	private void drawTitleBorder() {
		drawUpperTitleBorder();
		drawLeftTitleBorder();
		drawRightTitleBorder();
		drawLowerTitleBorder();
	}
	private void drawLowerPanelBorder() {
		setBorder(contentBorderLocation.x,
				contentBorderLocation.y +
				contentBorderDimension.height, 
				borderThickness,
				contentBorderDimension.width + 
				borderThickness, bContentBorder);		
	}
	private void drawRightPanelBorder() {
		setBorderVertical(contentBorderLocation.x +
				contentBorderDimension.width, 
				contentBorderLocation.y, 
				contentBorderDimension.height + 1, 
				borderThickness, rContentBorder);
	}
	private void drawLeftPanelBorder() {
		if(titlePosition)
		{
			//lowLeftBorderH é a altura da borda inferior
			//esquerda
			int lowLeftBorderH = titleBorderLocation.y-
				contentBorderLocation.y;
			setBorderVertical(contentBorderLocation.x,
				contentBorderLocation.y,
				lowLeftBorderH,
				borderThickness, sContentBorder);
			
			setBorderVertical(contentBorderLocation.x,
					contentBorderLocation.y +
					titleBorderDimension.height +
					lowLeftBorderH,
					this.getSize().height -
					(contentBorderLocation.y
					+ titleBorderDimension.height),
					borderThickness, lContentBorder);
			
		}
		else setBorderVertical(contentBorderLocation.x,
				contentBorderLocation.y,
				contentBorderDimension.height,
				borderThickness, lContentBorder);
	}
	private void drawUpperPanelBorder() {
		if(titlePosition)
			setBorder(contentBorderLocation.x,
				contentBorderLocation.y,
				borderThickness,
				contentBorderDimension.width, uContentBorder);
		else
		{
			setBorder(contentBorderLocation.x,
					contentBorderLocation.y,
					borderThickness,
					titleDistance -1, sContentBorder);
			/* iniULPostition é
			 * a posição inicial da borda
			 * superior direita. 
			 */
			int iniURPostition = 
				contentBorderLocation.x +
				(titleDistance -1) + 
				titleBorderDimension.width;
			setBorder(iniURPostition,
					contentBorderLocation.y,
					borderThickness,
					this.getSize().width -
					iniURPostition, uContentBorder);
		}
	}
	private void drawLowerTitleBorder() {
		setBorder(titleBorderLocation.x,
				titleBorderLocation.y +
				titleBorderDimension.height, 
				borderThickness,
				titleBorderDimension.width + borderThickness, bTitleBorder);		
	}
	private void drawRightTitleBorder() {
		setBorderVertical(titleBorderLocation.x +
				titleBorderDimension.width, 
				titleBorderLocation.y, 
				titleBorderDimension.height + 1, 
				borderThickness, rTitleBorder);
	}
	private void drawLeftTitleBorder() {
		setBorderVertical(titleBorderLocation.x,
				titleBorderLocation.y,
				titleBorderDimension.height,
				borderThickness, lTitleBorder);
		
	}
	private void drawUpperTitleBorder() {
		setBorder(titleBorderLocation.x,
				titleBorderLocation.y,
				borderThickness,
				titleBorderDimension.width, uTitleBorder);
	}
	
	private void setBorder(int x, int y,
			 int height, int width, JSeparator jSeparator)
	 {
        jSeparator.setLocation(x, y);
        jSeparator.setSize(width, height);
        add(jSeparator);
	 }
	 
	 private void setBorderVertical(int x, int y,
			 int height, int width, JSeparator jSeparator)
	 {
		jSeparator.setOrientation(SwingConstants.VERTICAL);
        jSeparator.setLocation(x, y);
        jSeparator.setSize(width, height);
        add(jSeparator);
	 }
}
